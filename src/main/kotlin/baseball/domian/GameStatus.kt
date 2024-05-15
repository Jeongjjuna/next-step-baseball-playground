package baseball.domian

class GameStatus(var strike: Int = 0, var ball: Int = 0) {

    fun increaseStrike() {
        strike += 1
    }

    fun increaseBall() {
        ball += 1
    }

    fun isNothing(): Boolean {
        return strike == 0 && ball == 0
    }

    fun isGameOver(): Boolean {
        return strike == 3
    }

}