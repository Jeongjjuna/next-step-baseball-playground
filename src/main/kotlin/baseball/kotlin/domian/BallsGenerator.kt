package baseball.kotlin.domian

import kotlin.random.Random

class BallsGenerator {

    companion object {
        private const val MIN_RANGE = 1
        private const val MAX_RANGE = 10
    }

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

    private fun generateBallList() = MutableList(3) { createRandomBall() }

    private fun createRandomBall() = Ball(Random.nextInt(MIN_RANGE, MAX_RANGE))
}