package baseball.java.domain;

import java.util.Arrays;

public enum UserAction {
    RESTART("1"),
    END("2");

    private final String description; // 필드

    // 생성자
    UserAction(String description) {
        this.description = description;
    }

    public static UserAction create(String input) {
        return Arrays.stream(UserAction.values())
                .filter(action -> action.description.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력값이 올바르지 않습니다."));
    }
}
