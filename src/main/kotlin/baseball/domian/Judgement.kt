package baseball.domian

class Judgement {

    fun judge(balls: Balls, targetBall: Ball, targetPosition: Int): ResultType {

        if (balls.isStrike(targetBall, targetPosition)) {
            return ResultType.STRIKE
        }

        if (balls.isBall(targetBall, targetPosition)) {
            return ResultType.BALL
        }

        return ResultType.NOTHING
    }
}