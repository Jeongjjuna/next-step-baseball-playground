package baseball.kotlin.domian

class Judgement {

    fun judge(balls: Balls, targetBall: Ball, targetPosition: Int) = when {
        balls.isStrike(targetBall, targetPosition) -> ResultType.STRIKE
        balls.isBall(targetBall, targetPosition) -> ResultType.BALL
        else -> ResultType.NOTHING
    }
}
