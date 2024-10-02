package baseball.java.domain;

import baseball.java.GameException;


public class Ball {

    private static final int MAX_NUM_RANGE = 9;
    private static final int MIN_NUM_RANGE = 1;

    private final int number;
    private final int pos;

    public Ball(int number, int pos) {
        this.number = number;
        this.pos = pos;
    }

    public static Ball create(int number, int pos) {
        validateRange(number);
        return new Ball(number, pos);
    }

    public boolean isBall(Ball otherBall) {
        return number == otherBall.number && pos != otherBall.pos;
    }

    public boolean isStrike(Ball otherBall) {
        return number == otherBall.number && pos == otherBall.pos;
    }

    private static void validateRange(int number) {
        if (number < MIN_NUM_RANGE || number > MAX_NUM_RANGE) {
            throw new GameException("[ERROR] Ball의 숫자 범위는 1~9 여야 합니다.");
        }
    }
}
