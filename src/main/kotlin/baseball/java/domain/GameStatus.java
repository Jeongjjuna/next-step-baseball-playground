package baseball.java.domain;

public enum GameStatus {
    IN_PROGRESS("진행중"),
    END("승리");

    private final String description;

    GameStatus(String description) {
        this.description = description;
    }
}
