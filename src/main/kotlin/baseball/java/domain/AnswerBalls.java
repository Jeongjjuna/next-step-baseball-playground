package baseball.java.domain;


import java.util.List;

public class AnswerBalls {

    private final Balls answerBall;
    private GameStatus gameStatus;

    private AnswerBalls(List<Integer> ballNums) {
        this.answerBall = Balls.create(ballNums);
        initializeAnswerBall();
    }

    public static AnswerBalls create(List<Integer> ballNums) {
        return new AnswerBalls(ballNums);
    }

    public void changeAnswerBallStatusToEnd() {
        this.gameStatus = GameStatus.END;
    }

    public boolean isInProgress() {
        return this.gameStatus == GameStatus.IN_PROGRESS;
    }

    private void initializeAnswerBall() {
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public int countBallAgainst(Balls userInputBalls) {
        return userInputBalls.countBallAgainst(answerBall);
    }

    public int countStrikeAgainst(Balls userInputBalls) {
        return userInputBalls.countStrikeAgainst(answerBall);
    }

    public boolean isThreeStrkieAgainst(Balls userInputBalls) {
        return userInputBalls.isThreeStrikeAgainst(answerBall);
    }
}
