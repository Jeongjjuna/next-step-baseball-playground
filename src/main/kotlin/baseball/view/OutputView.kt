package baseball.view

import baseball.domian.GameStatus

class OutputView {

    companion object {
        private const val GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        private const val BALL_MESSAGE = "%d볼 "
        private const val STRIKE_MESSAGE = "%d스트라이크"
        private const val NOTHING_MESSAGE = "낫싱"
    }

    fun printGameOver() {
        println(GAME_OVER_MESSAGE)
    }

    fun printResult(gameStatus: GameStatus) {
        if (gameStatus.isNothing()) {
            println(NOTHING_MESSAGE)
            return
        }

        val ballMessage = when (gameStatus.ball) {
            0 -> ""
            1, 2, 3 -> BALL_MESSAGE.format(gameStatus.ball)
            else -> throw IllegalArgumentException("[Error] 볼 개수는 0, 1, 2, 3개 중에 하나여야 합니다.")
        }

        val strikeMessage = when (gameStatus.strike) {
            0 -> ""
            1, 2, 3 -> STRIKE_MESSAGE.format(gameStatus.strike)
            else -> throw IllegalArgumentException("[Error] 스트라이크 개수는 0, 1, 2, 3개 중에 하나여야 합니다.")
        }

        println(ballMessage + strikeMessage)
    }
}