package baseball.controller

import baseball.const.ErrorMessage
import baseball.domian.Ball
import baseball.domian.Balls
import baseball.domian.GameStatus
import baseball.domian.Judgement
import baseball.domian.ResultType
import baseball.view.InputView
import baseball.view.OutputView

class GameController {

    private var isPlaying = true

    fun run() {
        do {
            play()
        } while (isPlaying)
    }

    private fun play() {

        // TODO : val ballGenerator = BallsGenerator()
        val judgement = Judgement()
        val inputView = InputView()
        val outputView = OutputView()

        val targetBalls = Balls(listOf(Ball(1), Ball(3), Ball(5)))


        do {
            val gameStatus = GameStatus()
            val userBalls = Balls(inputView.inputNumber())

            for (position in 0 until Balls.SIZE) {
                val result = judgement.judge(targetBalls, userBalls.balls[position], position)
                when (result) {
                    ResultType.STRIKE -> gameStatus.increaseStrike()
                    ResultType.BALL -> gameStatus.increaseBall()
                    else -> {}
                }
            }

            outputView.printResult(gameStatus)

            val gameOvered = gameStatus.isGameOver()
        } while (!gameOvered)

        outputView.printGameOver()

        when (inputView.inputRestart()) {
            "1" -> {}
            "2" -> isPlaying = false
            else -> throw IllegalArgumentException(ErrorMessage.RESTART_INPUT_EXCEPTION)
        }
    }

}