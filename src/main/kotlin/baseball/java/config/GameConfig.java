package baseball.java.config;

import baseball.java.gameLevel.GameLevel;
import baseball.java.infrastructure.BallGenerator;
import baseball.java.infrastructure.InputHandler;
import baseball.java.infrastructure.OutputHandler;

public final class GameConfig {

    private final GameLevel gameLevel;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final BallGenerator ballGenerator;


    public GameConfig(GameLevel gameLevel, InputHandler inputHandler, OutputHandler outputHandler, BallGenerator ballGenerator) {
        this.gameLevel = gameLevel;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.ballGenerator = ballGenerator;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public BallGenerator getBallGenerator() {
        return ballGenerator;
    }
}
