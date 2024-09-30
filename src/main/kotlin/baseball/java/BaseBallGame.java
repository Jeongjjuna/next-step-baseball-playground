package baseball.java;

import baseball.java.domain.Balls;
import baseball.java.domain.GameResult;
import baseball.java.domain.UserAction;
import baseball.java.infrastructure.BallGenerator;
import baseball.java.infrastructure.InputHandler;
import baseball.java.infrastructure.OutputHandler;

public class BaseBallGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final BallGenerator ballGenerator;

    public BaseBallGame(InputHandler inputHandler, OutputHandler outputHandler, BallGenerator ballGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.ballGenerator = ballGenerator;
    }

    public void run() {

        while (true) {
            Balls answerBalls = ballGenerator.generateBalls();

            while (true) {
                outputHandler.showBallNumsInputComment();

                Balls userInputBalls = inputHandler.getBallNumsFromUser();
                GameResult gameResult = getGameResult(userInputBalls, answerBalls);

                outputHandler.showBallNumsResult(gameResult);

                if (userInputBalls.isThreeStrikeAgainst(answerBalls)) {
                    outputHandler.showGameEndComment();
                    break;
                }
            }

            outputHandler.showRestartComment();
            UserAction userActionAboutRestart = inputHandler.getRestartInputFromUser();

            if (userActionAboutRestart == UserAction.END) {
                break;
            }
        }
    }

    private GameResult getGameResult(Balls userInputBalls, Balls answerBalls) {
        int ball = userInputBalls.countBallAgainst(answerBalls);
        int strike = userInputBalls.countStrikeAgainst(answerBalls);
        return new GameResult(ball, strike);
    }
}
