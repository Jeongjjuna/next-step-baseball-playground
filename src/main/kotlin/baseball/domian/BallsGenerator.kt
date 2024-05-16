package baseball.domian

import kotlin.random.Random

class BallsGenerator {

    fun generate(): Balls {
        var balls: Balls

        while (true) {
            try {
                balls = Balls(generateBallList())
                return balls
            } catch (e: IllegalArgumentException) {
            }
        }
    }

    private fun generateBallList(): List<Ball> {
        val ballList = mutableListOf<Ball>()
        repeat(3) {
            val ball = Ball(Random.nextInt(1, 10))
            ballList.add(ball)
        }
        return ballList
    }

}