package baseball.view

import baseball.domian.GameStatus

class OutputView {
    fun printGameOver() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun printResult(gameStatus: GameStatus) {
        if (gameStatus.isNothing()) {
            println("낫싱")
            return
        }

        val ballMessage = when (gameStatus.ball) {
            0 -> ""
            else -> "${gameStatus.ball}볼 "
        }

        val strikeMessage = when (gameStatus.strike) {
            0 -> ""
            else -> "${gameStatus.strike}" + "스트라이크"
        }

        println(ballMessage + strikeMessage)
    }
}