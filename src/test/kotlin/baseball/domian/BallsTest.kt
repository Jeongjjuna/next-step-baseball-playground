package baseball.domian

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

@DisplayName("[단위테스트] Balls")
class BallsTest : DescribeSpec({

    describe("create() 테스트") {
        context("크기가 3인 List<Ball>이 주어지면") {
            val validSize = Balls.SIZE
            val balls = List(validSize) { index -> Ball(index + 1) }
            it("생성에 성공한다.") {
                shouldNotThrowAny {
                    Balls(balls)
                }
            }
        }

        context("크기가 Balls.SIZE가 아닌 List<Balls>가 주어지면") {
            val invalidSize = Balls.SIZE + 1
            val balls = List(invalidSize) { index -> Ball(index + 1) }
            it("생성에 실패한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Balls.create(balls)
                }
                exception.message should startWith("[Error]")
            }
        }
    }

})