package baseball.java.domain;

public enum SessionStatus {
    CONNECTING("세션 연결중"),
    DISCONNECTED("세션 끊김");

    private final String description;

    SessionStatus(String description) {
        this.description = description;
    }
}
