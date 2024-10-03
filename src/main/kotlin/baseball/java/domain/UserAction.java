package baseball.java.domain;

import baseball.java.GameException;

import java.util.Arrays;

public enum UserAction {
    RESTART("1"),
    END("2");

    private final String description; // 필드

    UserAction(String description) {
        this.description = description;
    }

    public static UserAction create(String input) {
        return Arrays.stream(UserAction.values())
                .filter(action -> action.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new GameException("[ERROR] 지원되지 않는 요청입니다."));
    }
}
