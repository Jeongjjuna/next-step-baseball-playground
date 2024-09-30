package baseball.kotlin.view

class InputView {

    companion object {
        private const val START_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        private const val INPUT_MESSAGE = "숫자를 입력해 주세요 : "
    }

    fun inputRestart(): String {
        println(START_MESSAGE)
        return readln()
    }

    fun inputNumber(): String {
        print(INPUT_MESSAGE)
        return readln()
    }
}
