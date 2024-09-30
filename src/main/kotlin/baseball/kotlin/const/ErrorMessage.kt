package baseball.kotlin.const

object ErrorMessage {
    private const val ERROR_PREFIX = "[Error] : "

    private fun createMessage(message: String) : String {
        return ERROR_PREFIX + message
    }

    val BALL_COUNT_EXCEPTION = createMessage("볼 개수는 0, 1, 2, 3개 중에 하나여야 합니다.")
    val STRIKE_COUNT_EXCEPTION = createMessage("스트라이크 개수는 0, 1, 2, 3개 중에 하나여야 합니다.")
    val BALL_RANGE_EXCEPTION = createMessage("BALL의 숫자 범위 초과")
    val RESTART_INPUT_EXCEPTION = createMessage("재시작 응답은 1 혹은 2로만 입력해야함")
    val BALLS_SIZE_EXCEPTION = createMessage("BALLS의 size가 3이 아님")
    val BALLS_UNIQUE_EXCEPTION = createMessage("BALLS의 Ball들이 서로 다른 숫자가 아님")
    val NUMBER_FORMAT_EXCEPTION = createMessage("입력값은 숫자여야 합니다.")
    val NULL_EXCEPTION = createMessage("Null 값이 될 수 없습니다.")

}