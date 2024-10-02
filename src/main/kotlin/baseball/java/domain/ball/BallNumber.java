package baseball.java.domain.ball;

import baseball.java.GameException;

import java.util.Objects;

public class BallNumber {

    private static final int MAX_NUM_RANGE = 9;
    private static final int MIN_NUM_RANGE = 1;

    private final int number;

    public BallNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private static void validateRange(int number) {
        if (number < MIN_NUM_RANGE || number > MAX_NUM_RANGE) {
            throw new GameException("[ERROR] Ball의 숫자 범위는 1~9 여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber ballNumber1 = (BallNumber) o;
        return number == ballNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

}
