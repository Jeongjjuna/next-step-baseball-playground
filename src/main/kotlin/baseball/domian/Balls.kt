package baseball.domian

class Balls(val balls: List<Ball>) {

    init {
        validateSize(balls)
        validateUnique(balls)
    }

    companion object {
        const val SIZE = 3

        fun create(balls: List<Ball>): Balls {
            return Balls(balls)
        }
    }

    private fun validateSize(balls: List<Ball>) {
        if (balls.size != SIZE) {
            throw IllegalArgumentException("[Error] : BALLS의 size가 3이 아님")
        }
    }

    private fun validateUnique(balls: List<Ball>) {
        val distinctNums = balls.map { ball -> ball.num }.distinct()
        if (distinctNums.size != balls.size) {
            throw IllegalArgumentException("[Error] : BALLS의 Ball들이 서로 다른 숫자가 아님")
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