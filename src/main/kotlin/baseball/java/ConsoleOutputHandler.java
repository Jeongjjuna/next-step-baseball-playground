package baseball.java;

import baseball.java.domain.GameResult;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showBallNumsInputComment() {
        System.out.println("숫자를 입력해 주세요 : ");
    }

    @Override
    public void showBallNumsResult(GameResult gameResult) {
        int ball = gameResult.getBall();
        int strike = gameResult.getStrike();

        String ballMessage = ball + "볼 ";
        String strikeMessage = strike + "스트라이크";

        if (ball == 0) {
            ballMessage = "";
        }
        if (strike == 0) {
            strikeMessage = "";
        }

        String resultMessage = ballMessage + strikeMessage;
        if (ball == 0 && strike == 0) {
            resultMessage = "낫싱";
        }

        System.out.println(resultMessage);
    }

    @Override
    public void showGameEndComment() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void showRestartComment() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
