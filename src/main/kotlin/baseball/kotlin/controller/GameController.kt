package baseball.kotlin.controller

import baseball.kotlin.const.ErrorMessage
import baseball.kotlin.domian.Balls
import baseball.kotlin.domian.BallsGenerator
import baseball.kotlin.domian.GameStatus
import baseball.kotlin.domian.Judgement
import baseball.kotlin.domian.ResultType
import baseball.kotlin.view.InputView
import baseball.kotlin.view.OutputView

class GameController(
    val ballGenerator: BallsGenerator = BallsGenerator(),
    val judgement: Judgement = Judgement(),
    val inputView: InputView = InputView(),
    val outputView: OutputView = OutputView(),
) {

    private var isPlaying: Boolean = true
    private var gameOvered: Boolean = false
    private var gameStatus: GameStatus = GameStatus()
    private var targetBalls: Balls? = null
    private var userBalls: Balls? = null

    fun run() {
        while (isPlaying) {
            play()
        }
    }

    private fun play() {

        initTargetBall()

        while (!gameOvered) {
            initGameStatus()

            inputUserNumberUntilValidInput()
            calculateResult()
            printResult()

            checkGameOvered()
        }

        printGameResult()
        checkRestart()
    }

    private fun checkRestart() {
        when (inputView.inputRestart()) {
            "1" -> {}
            "2" -> isPlaying = false
            else -> throw IllegalArgumentException(ErrorMessage.RESTART_INPUT_EXCEPTION)
        }
    }

    private fun printGameResult() {
        outputView.printGameOver()
    }

    private fun checkGameOvered() {
        gameOvered = gameStatus.isGameOver()
    }

    private fun printResult() {
        outputView.printResult(gameStatus)
    }

    private fun calculateResult() {
        val checkedTargetBalls = checkNotNull(targetBalls) { ErrorMessage.NULL_EXCEPTION }
        val checkedUserBalls = checkNotNull(userBalls) { ErrorMessage.NULL_EXCEPTION }

        for (position in 0 until Balls.SIZE) {
            val result = judgement.judge(checkedTargetBalls, checkedUserBalls.balls[position], position)
            applyResult(result)
        }
    }

    private fun applyResult(result: ResultType) {
        when (result) {
            ResultType.STRIKE -> gameStatus.increaseStrike()
            ResultType.BALL -> gameStatus.increaseBall()
            else -> {}
        }
    }

    private fun inputUserNumberUntilValidInput() {
        var isValidInput = false
        while (!isValidInput) {
            isValidInput = inputUserNumber()
        }
    }

    private fun inputUserNumber(): Boolean {
        try {
            userBalls = Balls(inputView.inputNumber())
            return true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
        return false
    }

    private fun initTargetBall() {
        targetBalls = ballGenerator.generate()
    }

    private fun initGameStatus() {
        gameStatus = GameStatus()
    }

}