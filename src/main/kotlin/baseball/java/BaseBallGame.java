package baseball.java;

import baseball.java.config.GameConfig;
import baseball.java.domain.AnswerBalls;
import baseball.java.domain.Balls;
import baseball.java.domain.GameResult;
import baseball.java.domain.GameSession;
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
    private GameSession gameSession;

    public BaseBallGame(GameConfig gameConfig) {
        this.inputHandler = gameConfig.getInputHandler();
        this.outputHandler = gameConfig.getOutputHandler();
        this.ballGenerator = gameConfig.getBallGenerator();
    }

    @Override
    public void initialize() {
        initializeGameSession();
    }

    @Override
    public void run() {

        try {
            while (gameSession.isInProgress()) {
                initializeGameSession();
                AnswerBalls answerBalls = ballGenerator.generateBalls();

                while (answerBalls.isInProgress()) {
                    outputHandler.showBallNumsInputComment();

                    Balls userInputBalls = inputHandler.getBallNumsFromUser();

                    GameResult gameResult = getGameResult(userInputBalls, answerBalls);

                    outputHandler.showBallNumsResult(gameResult);

                    if (answerBalls.isThreeStrkieAgainst(userInputBalls)) {
                        outputHandler.showGameEndComment();
                        answerBalls.changeAnswerBallStatusToEnd();
                    }
                }

                outputHandler.showRestartComment();
                UserAction userActionAboutRestart = inputHandler.getRestartInputFromUser();

                if (userActionAboutRestart == UserAction.END) {
                    gameSession.changeGameStatusToEnd();
                }
            }
        } catch (GameException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("[ERROR] Internal System Error");
        }
    }

    private void initializeGameSession() {
        this.gameSession = GameSession.init();
    }

    private GameResult getGameResult(Balls userInputBalls, AnswerBalls answerBalls) {
        int ball = answerBalls.countBallAgainst(userInputBalls);
        int strike = answerBalls.countStrikeAgainst(userInputBalls);
        return new GameResult(ball, strike);
    }

}
