package baseball.kotlin.view

import baseball.kotlin.const.ErrorMessage
import baseball.kotlin.domian.GameStatus

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
            in 1..3 -> BALL_MESSAGE.format(gameStatus.ball)
            else -> throw IllegalArgumentException(ErrorMessage.BALL_COUNT_EXCEPTION)
        }

        val strikeMessage = when (gameStatus.strike) {
            0 -> ""
            in 1..3 -> STRIKE_MESSAGE.format(gameStatus.strike)
            else -> throw IllegalArgumentException(ErrorMessage.STRIKE_COUNT_EXCEPTION)
        }

        println(ballMessage + strikeMessage)
    }
}