package baseball.domian

import baseball.const.ErrorMessage

class Balls(val balls: List<Ball>) {

    init {
        require(isSize(balls)) { ErrorMessage.BALLS_SIZE_EXCEPTION }
        require(isUnique(balls)) { ErrorMessage.BALLS_UNIQUE_EXCEPTION }
    }

    constructor(balls: String) : this(
        balls.toBallList()
    )

    companion object {
        const val SIZE = 3

        fun create(balls: List<Ball>): Balls = Balls(balls)
    }

    private fun isSize(balls: List<Ball>) = balls.size == SIZE

    private fun isUnique(balls: List<Ball>): Boolean {
        val distinctNums = balls.map { ball -> ball.num }.distinct()
        return distinctNums.size == balls.size
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

/**
 * String 확장 클래스
 */
fun String.toBallList(): List<Ball> {
    try {
        return this.map { c -> Ball(c.toString().toInt()) }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_EXCEPTION, e)
    }
}