package baseball.java.domain;

import baseball.java.gameLevel.GameLevel;

public class GameRound {

    private final GameLevel gameLevel;
    private GameStatus gameStatus;
    private int count;

    public GameRound(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.count = gameLevel.getRemainAttempts();
    }

    public int countDown() {
        this.count -= 1;
        changeRoundStatusToEndIfCountZero();
        return this.count;
    }

    public void reset() {
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.count = gameLevel.getRemainAttempts();
    }

    public boolean isInProgress() {
        return this.gameStatus == GameStatus.IN_PROGRESS;
    }

    private GameStatus changeRoundStatusToEndIfCountZero() {
        if (count == 0) {
            changeGameStatusToEnd();
        }
        return gameStatus;
    }

    private void changeGameStatusToEnd() {
        this.gameStatus = GameStatus.END;
    }
}
