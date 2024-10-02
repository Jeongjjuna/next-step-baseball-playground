package baseball.java.domain.ball;

import java.util.Objects;

public class BallPosition {

    private final int position;

    public BallPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallPosition that = (BallPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
