package baseball.domian

import baseball.const.ErrorMessage

class Balls(val balls: List<Ball>) {

    init {
        validateSize(balls)
        validateUnique(balls)
    }

    constructor(balls: String): this(
        parserBallsFromString(balls)
    )

    companion object {
        const val SIZE = 3

        fun create(balls: List<Ball>): Balls {
            return Balls(balls)
        }

        private fun parserBallsFromString(balls: String): List<Ball> {
            try {
                return balls.map { c -> Ball(c.toString().toInt()) }
            }catch (e: NumberFormatException) {
                throw IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_EXCEPTION, e)
            }
        }
    }

    private fun validateSize(balls: List<Ball>) {
        if (balls.size != SIZE) {
            throw IllegalArgumentException(ErrorMessage.BALLS_SIZE_EXCEPTION)
        }
    }

    private fun validateUnique(balls: List<Ball>) {
        val distinctNums = balls.map { ball -> ball.num }.distinct()
        if (distinctNums.size != balls.size) {
            throw IllegalArgumentException(ErrorMessage.BALLS_UNIQUE_EXCEPTION)
        }

    }

    fun isStrike(targetBall: Ball, targetPosition: Int): Boolean {
        for (position in 0 until SIZE) {
            if (targetBall.isMatch(balls[position]) && targetPosition == position) {
                return true
            }
        }
        return false
    }

    fun isBall(targetBall: Ball, targetPosition: Int): Boolean {
        for (position in 0 until SIZE) {
            if (targetBall.isMatch(balls[position]) && targetPosition != position) {
                return true
            }
        }
        return false
    }

}