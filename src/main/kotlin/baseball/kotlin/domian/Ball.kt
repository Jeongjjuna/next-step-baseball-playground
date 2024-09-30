package baseball.kotlin.domian

import baseball.kotlin.const.ErrorMessage

class Ball(val num: Int) {

    init {
        require(isRange(num)) { ErrorMessage.BALL_RANGE_EXCEPTION }
    }

    companion object {
        private const val MIN_RANGE = 1
        private const val MAX_RANGE = 9

        fun create(num: Int): Ball = Ball(num)
    }

    fun isMatch(testBall: Ball) = this.num == testBall.num

    private fun isRange(num: Int) = num in MIN_RANGE..MAX_RANGE
}
