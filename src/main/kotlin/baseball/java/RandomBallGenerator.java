package baseball.java;

import baseball.java.domain.Balls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBallGenerator implements BallGenerator{

    /**
     * Random 외부 API를 주입받아서 사용해야, 테스트를 구현할 수 있을 것 같다.
     */
    @Override
    public Balls generateBalls() {
        Random random = new Random();

        List<Integer> ballNums = new ArrayList<>();
        for (int pos = 0; pos < Balls.SIZE; pos++) {
            int num = random.nextInt(1, 10);
            ballNums.add(num);
        }

        System.out.println(ballNums);
        return Balls.create(ballNums);
    }
}
