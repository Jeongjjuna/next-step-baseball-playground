package baseball.domian

class Balls(val balls: List<Ball>) {

    init {
        validateSize(balls)
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

}