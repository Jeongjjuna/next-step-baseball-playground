package baseball.java;

import baseball.java.config.GameConfig;
import baseball.java.domain.Balls;
import baseball.java.domain.GameResult;
import baseball.java.domain.UserAction;
import baseball.java.game.GameInitializable;
import baseball.java.game.GameRunnable;
import baseball.java.infrastructure.BallGenerator;
import baseball.java.infrastructure.InputHandler;
import baseball.java.infrastructure.OutputHandler;

public class BaseBallGame implements GameInitializable, GameRunnable {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final BallGenerator ballGenerator;

    private Balls answerBalls;

    public BaseBallGame(GameConfig gameConfig) {
        this.inputHandler = gameConfig.getInputHandler();
        this.outputHandler = gameConfig.getOutputHandler();
        this.ballGenerator = gameConfig.getBallGenerator();
    }

    @Override
    public void initialize() {
        initializeAnswerBall();
    }

    @Override
    public void run() {

        while (true) {
            initializeAnswerBall();

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

    private void initializeAnswerBall() {
        this.answerBalls = ballGenerator.generateBalls();
    }

    private GameResult getGameResult(Balls userInputBalls, Balls answerBalls) {
        int ball = userInputBalls.countBallAgainst(answerBalls);
        int strike = userInputBalls.countStrikeAgainst(answerBalls);
        return new GameResult(ball, strike);
    }

}
