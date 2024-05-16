package baseball.domian

import baseball.const.ErrorMessage

class Ball(val num: Int) {

    init {
        validateRange(num)
    }

    companion object {
        private const val MIN_RANGE = 1
        private const val MAX_RANGE = 9

        fun create(num: Int): Ball {
            return Ball(num)
        }
    }

    private fun validateRange(num: Int) {
        if (num < MIN_RANGE || MAX_RANGE < num) {
            throw IllegalArgumentException(ErrorMessage.BALL_RANGE_EXCEPTION)
        }
    }

    fun isMatch(testBall: Ball): Boolean {
        return this.num == testBall.num
    }
}
