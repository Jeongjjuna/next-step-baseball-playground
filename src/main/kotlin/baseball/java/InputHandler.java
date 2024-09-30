package baseball.java;

import baseball.java.domain.Balls;
import baseball.java.domain.UserAction;

public interface InputHandler {

    Balls getBallNumsFromUser();

    UserAction getRestartInputFromUser();
}
