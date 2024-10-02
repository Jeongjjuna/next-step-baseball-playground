package baseball.java;

import baseball.java.config.GameConfig;
import baseball.java.domain.Balls;
import baseball.java.domain.GameResult;
import baseball.java.domain.GameRound;
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
    private final GameRound gameRound;
    private GameSession gameSession;

    public BaseBallGame(GameConfig gameConfig) {
        this.inputHandler = gameConfig.getInputHandler();
        this.outputHandler = gameConfig.getOutputHandler();
        this.ballGenerator = gameConfig.getBallGenerator();
        this.gameRound = new GameRound(gameConfig.getGameLevel());
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

                initializeGameRound();
                Balls answerBalls = ballGenerator.generateBalls();

                while (gameRound.isInProgress()) {

                    outputHandler.showBallNumsInputComment();
                    Balls userInputBalls = inputHandler.getBallNumsFromUser();

                    GameResult gameResult = getGameResult(userInputBalls, answerBalls);
                    outputHandler.showBallNumsResult(gameResult);

                    if (userInputBalls.isThreeStrikeAgainst(answerBalls)) {
                        outputHandler.showGameEndComment();
                    }

                    int remainCount = gameRound.countDown();
                    outputHandler.showRemainAttempts(remainCount);
                }

                outputHandler.showRestartComment();
                UserAction userActionAboutRestart = inputHandler.getRestartInputFromUser();

                if (userActionAboutRestart == UserAction.END) {
                    gameSession.changeGameStatusToEnd();
                }
            }
        } catch (GameException e) {
            // log.error 게임 속에서 나오는 의도된 에러들
        } catch (Exception e) {
            System.out.println("[ERROR] Internal System Error");
        }
    }

    private void initializeGameSession() {
        this.gameSession = GameSession.init();
    }

    private void initializeGameRound() {
        gameRound.reset();
    }

    private GameResult getGameResult(Balls userInputBalls, Balls answerBalls) {
        int ball = answerBalls.countBallAgainst(userInputBalls);
        int strike = answerBalls.countStrikeAgainst(userInputBalls);
        return new GameResult(ball, strike);
    }

}
