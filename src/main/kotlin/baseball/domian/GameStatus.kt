package baseball.domian

class GameStatus(var strike: Int = 0, var ball: Int = 0) {

    fun increaseStrike() {
        strike += 1
    }

    fun increaseBall() {
        ball += 1
    }

    fun isNothing(): Boolean  = strike == 0 && ball == 0

    fun isGameOver(): Boolean = strike == 3

}