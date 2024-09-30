package baseball.java;

import baseball.java.domain.GameResult;

public interface OutputHandler {

    void showBallNumsInputComment();

    void showBallNumsResult(GameResult gameResult);

    void showGameEndComment();

    void showRestartComment();
}
