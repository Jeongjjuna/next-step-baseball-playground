package baseball.java.infrastructure;

import baseball.java.domain.AnswerBalls;
import baseball.java.domain.Balls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBallGenerator implements BallGenerator {

    private final Random random = new Random();
    /**
     * Random 외부 API를 주입받아서 사용해야, 테스트를 구현할 수 있을 것 같다.
     */
    @Override
    public AnswerBalls generateBalls() {

        while (true) {
            List<Integer> ballNums = new ArrayList<>();
            for (int pos = 0; pos < Balls.SIZE; pos++) {
                int num = random.nextInt(1, 10);
                ballNums.add(num);
            }

            try {
                return AnswerBalls.create(ballNums);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
