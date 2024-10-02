package baseball.java.infrastructure;

import baseball.java.domain.UserAction;
import baseball.java.domain.ball.Balls;

public interface InputHandler {

    Balls getBallNumsFromUser();

    UserAction getRestartInputFromUser();
}
