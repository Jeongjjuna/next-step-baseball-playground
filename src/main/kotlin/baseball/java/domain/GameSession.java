package baseball.java.domain;

public class GameSession {
    private SessionStatus status;

    private GameSession() {
        initializeGameStatus();
    }

    public static GameSession init() {
        return new GameSession();
    }

    public void changeGameStatusToEnd() {
        this.status = SessionStatus.DISCONNECTED;
    }

    public boolean isInProgress() {
        return status == SessionStatus.CONNECTING;
    }

    private void initializeGameStatus() {
        this.status = SessionStatus.CONNECTING;
    }
}
