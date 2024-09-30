package baseball.java;

public class Application {

    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        BaseBallGame baseBallGame = new BaseBallGame(inputHandler, outputHandler);
        baseBallGame.run();
    }
}
