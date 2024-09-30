package baseball.java;

import baseball.java.infrastructure.BallGenerator;
import baseball.java.infrastructure.ConsoleInputHandler;
import baseball.java.infrastructure.ConsoleOutputHandler;
import baseball.java.infrastructure.InputHandler;
import baseball.java.infrastructure.OutputHandler;
import baseball.java.infrastructure.RandomBallGenerator;

public class Application {

    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        BallGenerator ballGenerator = new RandomBallGenerator();

        BaseBallGame baseBallGame = new BaseBallGame(inputHandler, outputHandler, ballGenerator);
        baseBallGame.run();
    }
}
