package baseball.java.infrastructure;

import baseball.java.GameException;
import baseball.java.domain.UserAction;
import baseball.java.domain.ball.Balls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleInputHandler implements InputHandler {

    private static final Logger LOGGER = Logger.getLogger(ConsoleInputHandler.class.getName());

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Balls getBallNumsFromUser() {

        while (true) {
            String input = scanner.next();

            List<Integer> nums = new ArrayList<>();

            for (char expectedNumeric : input.toCharArray()) {
                nums.add(Character.getNumericValue(expectedNumeric));
            }

            try {
                return Balls.create(nums);
            } catch (GameException e) {
                LOGGER.info(e.getMessage());
            }
        }

    }

    @Override
    public UserAction getRestartInputFromUser() {
        while (true) {
            String input = scanner.next();
            try {
                return UserAction.create(input);
            } catch (GameException e) {
                LOGGER.info(e.getMessage());
            }
        }
    }
}
