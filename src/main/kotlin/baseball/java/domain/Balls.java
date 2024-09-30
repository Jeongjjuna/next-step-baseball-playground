package baseball.java.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private static final int BALLS_SIZE = 3;

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls create(List<Integer> ballNums) {

        validateSize(ballNums);

        List<Ball> balls = createBallListOf(ballNums);
        return new Balls(balls);
    }

    private static void validateSize(List<Integer> ballNums) {
        if (ballNums.size() != BALLS_SIZE) {
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
}
