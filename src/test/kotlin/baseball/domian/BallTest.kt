package baseball.domian

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

class BallTest : BehaviorSpec({

    Given("1~9사이의 숫가 주어지고") {
        val nums = listOf(1, 5, 9)
        When("Ball 클래스를 생성하면") {
            Then("성공") {
                nums.forAll {
                    shouldNotThrowAny {
                        Ball.create(it)
                    }
                }
            }
        }
    }

    Given("1~9이 외의 숫가 주어지고") {
        val nums = listOf(0, 10, 999)
        When("Ball 클래스를 생성하면") {
            Then("예외를 반환") {
                nums.forAll {
                    val exception = shouldThrow<IllegalArgumentException> {
                        Ball.create(it)
                    }
                    exception.message should startWith("[Error]")
                }
            }
        }
    }

})
