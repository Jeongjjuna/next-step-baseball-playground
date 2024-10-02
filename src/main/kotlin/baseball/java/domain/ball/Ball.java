package baseball.java.domain.ball;

public class Ball {

    private final BallNumber number;
    private final BallPosition position;

    public Ball(int number, int position) {
        this.number = new BallNumber(number);
        this.position = new BallPosition(position);
    }

    public static Ball create(int number, int pos) {
        return new Ball(number, pos);
    }

    public boolean isBall(Ball otherBall) {
        return otherBall.has(number) && otherBall.doseNotHave(position);
    }

    public boolean isStrike(Ball otherBall) {
        return otherBall.has(number) && otherBall.has(position);
    }

    private boolean has(BallNumber number) {
        return this.number.equals(number);
    }

    private boolean has(BallPosition position) {
        return this.position.equals(position);
    }

    private boolean doseNotHave(BallPosition position) {
        return !has(position);
    }

}
