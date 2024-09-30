package baseball.java;

import baseball.java.config.GameConfig;
import baseball.java.infrastructure.ConsoleInputHandler;
import baseball.java.infrastructure.ConsoleOutputHandler;
import baseball.java.infrastructure.RandomBallGenerator;

public class Application {

    public static void main(String[] args) {

        GameConfig gameConfig = new GameConfig(
                new ConsoleInputHandler(),
                new ConsoleOutputHandler(),
                new RandomBallGenerator()
        );

        BaseBallGame baseBallGame = new BaseBallGame(gameConfig);

        baseBallGame.initialize();
        baseBallGame.run();
    }
}
