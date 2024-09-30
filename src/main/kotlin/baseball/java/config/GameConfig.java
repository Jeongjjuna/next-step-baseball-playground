package baseball.java.config;

import baseball.java.infrastructure.BallGenerator;
import baseball.java.infrastructure.InputHandler;
import baseball.java.infrastructure.OutputHandler;

public final class GameConfig {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final BallGenerator ballGenerator;

    public GameConfig(InputHandler inputHandler, OutputHandler outputHandler, BallGenerator ballGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.ballGenerator = ballGenerator;
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
