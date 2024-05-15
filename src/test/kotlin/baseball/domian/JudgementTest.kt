package baseball.domian

import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

@DisplayName("[단위테스트] judgement")
class JudgementTest : DescribeSpec({

    val judgement = Judgement()

    describe("judge() 테스트") {
        context("같은 숫자가 있고, 위치도 같은 경우") {
            val balls = Balls(listOf(Ball(1), Ball(3), Ball(5)))
            val targetBall = Ball(3)
            val targetPosition = 1
            it("스트라이크 반환") {
                val result = judgement.judge(balls, targetBall, targetPosition)
                result.shouldBe(ResultType.STRIKE)
            }
        }
        context("숫자는 있지만, 위치는 다를 경우") {
            val balls = Balls(listOf(Ball(1), Ball(3), Ball(5)))
            val targetBall = Ball(3)
            val targetPosition = 2
            it("볼 반환") {
                val result = judgement.judge(balls, targetBall, targetPosition)
                result.shouldBe(ResultType.BALL)
            }
        }
        context("같은 숫자가 없을 경우") {
            val balls = Balls(listOf(Ball(1), Ball(3), Ball(5)))
            val targetBall = Ball(6)
            val targetPosition = 1
            it("낫씽 반환") {
                val result = judgement.judge(balls, targetBall, targetPosition)
                result.shouldBe(ResultType.NOTHING)
            }
        }
    }

})