package baseball.domian

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

@DisplayName("[단위테스트] Ball")
class BallTest : DescribeSpec({

    describe("create() 테스트") {
        context("1~9범위의 입력값이 주어지면") {
            val nums = listOf<Int>(1, 5, 9)
            it("생성에 성공한다.") {
                nums.forAll { num ->
                    shouldNotThrowAny {
                        Ball.create(num)
                    }
                }
            }
        }

        context("1~9가 아닌 입력값이 주어지면") {
            val nums = listOf<Int>(0, 10, 999)
            it("생성에 실패한다.") {
                nums.forAll { num ->
                    val exception = shouldThrow<IllegalArgumentException> {
                        Ball.create(num)
                    }
                    exception.message should startWith("[Error]")
                }
            }
        }
    }

})
