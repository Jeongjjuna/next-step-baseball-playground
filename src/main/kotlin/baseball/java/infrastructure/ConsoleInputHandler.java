package baseball.java.infrastructure;

import baseball.java.GameException;
import baseball.java.domain.Balls;
import baseball.java.domain.UserAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

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
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public UserAction getRestartInputFromUser() {
        String input = scanner.next();
        return UserAction.create(input);
    }
}
