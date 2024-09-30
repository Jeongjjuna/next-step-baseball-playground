package baseball.java.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    public static final int SIZE = 3;

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls create(List<Integer> ballNums) {

        validateSize(ballNums);
        validateDuplicate(ballNums);

        List<Ball> balls = createBallListOf(ballNums);
        return new Balls(balls);
    }

    private static void validateDuplicate(List<Integer> ballNums) {
        Set uniquNums = new HashSet<>(ballNums);
        if (uniquNums.size() != ballNums.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 값으로 생성할 수 없습니다.");
        }
    }

    private static void validateSize(List<Integer> ballNums) {
        if (ballNums.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] Balls의 길이는 3 이어야 합니다.");
        }
    }

    private static List<Ball> createBallListOf(List<Integer> ballNums) {
        List<Ball> balls = new ArrayList<>();
        for (int pos = 0; pos < ballNums.size(); pos++) {
            Ball ball = Ball.create(ballNums.get(pos), pos);
            balls.add(ball);
        }
        return balls;
    }

    public boolean isThreeStrikeAgainst(Balls otherBalls) {
        return balls.stream()
                .allMatch(otherBalls::isStrike);
    }

    public int countBallAgainst(Balls otherBalls) {
        return (int) balls.stream()
                .filter(otherBalls::isBall)
                .count();
    }

    public int countStrikeAgainst(Balls otherBalls) {
        return (int) balls.stream()
                .filter(otherBalls::isStrike)
                .count();
    }

    private boolean isBall(Ball otherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.isBall(otherBall));
    }

    private boolean isStrike(Ball otherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.isStrike(otherBall));
    }

}
