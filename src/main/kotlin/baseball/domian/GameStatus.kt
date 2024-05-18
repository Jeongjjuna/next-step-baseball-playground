package baseball.domian

class GameStatus(strike: Int = 0, ball: Int = 0) {

    var strike = strike
        private set
    var ball = ball
        private set

    fun increaseStrike() {
        strike += 1
    }

    fun increaseBall() {
        ball += 1
    }

    fun isNothing(): Boolean  = strike == 0 && ball == 0

    fun isGameOver(): Boolean = strike == 3

}