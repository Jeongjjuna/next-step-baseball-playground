package baseball.java.infrastructure;

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
    public Balls generateBalls() {

        while (true) {
            List<Integer> ballNums = new ArrayList<>();
            for (int pos = 0; pos < Balls.SIZE; pos++) {
                int num = random.nextInt(1, 10);
                ballNums.add(num);
            }

            try {
                return Balls.create(ballNums);
            } catch (IllegalArgumentException e) {
                // 중복 문자 생성으로 인한 예외 발생
            }
        }
    }
}
