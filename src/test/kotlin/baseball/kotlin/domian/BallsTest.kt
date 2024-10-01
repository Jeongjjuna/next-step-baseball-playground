package baseball.kotlin.domian

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

@DisplayName("[단위테스트] Balls")
class BallsTest : DescribeSpec({

    describe("create() 테스트") {
        context("크기가 3이고 숫자형태의 String이 주어지면") {
            val balls = "123"
            it("생성에 성공한다.") {
                shouldNotThrowAny {
                    Balls(balls)
                }
            }
        }

        context("크기가 문자형식의 String이 주어지면") {
            val input = listOf("가나다", "12&", "12A")
            it("생성에 실패한다.") {
                input.forAll { balls ->
                    val exception = shouldThrowAny {
                        Balls(balls)
                    }
                }
            }
        }

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

        context("서로 같은 숫자의 Ball가 존재한다면") {
            val input = listOf<List<Ball>>(
                listOf(Ball(1), Ball(1), Ball(1)),
                listOf(Ball(1), Ball(1), Ball(2))
            )
            it("생성에 실패한다.") {
                input.forAll { balls ->
                    val exception = shouldThrow<IllegalArgumentException> {
                        Balls.create(balls)
                    }
                    exception.message should startWith("[Error]")
                }
            }
        }
    }

    describe("isStrike() 테스트") {
        val balls = Balls(listOf(Ball(1), Ball(3), Ball(5)))
        context("같은 위치에 같은 숫자가 주어지면") {
            it("true를 반환한다.") {
                val result = balls.isStrike(Ball(3), 1)
                result.shouldBeTrue()
            }
        }
        context("같은 위치에 다른 숫자가 주어지면") {
            it("false를 반환한다.") {
                val result = balls.isStrike(Ball(4), 1)
                result.shouldBeFalse()
            }
        }
        context("다른 위치에 같은 숫자가 주어지면") {
            it("false를 반환한다.") {
                val result = balls.isStrike(Ball(3), 2)
                result.shouldBeFalse()
            }
        }
        context("다른 위치에 다른 숫자가 주어지면") {
            it("false를 반환한다.") {
                val result = balls.isStrike(Ball(4), 2)
                result.shouldBeFalse()
            }
        }
    }

    describe("isBall() 테스트") {
        val balls = Balls(listOf(Ball(1), Ball(3), Ball(5)))
        context("다른 위치에 같은숫자가 주어지면") {
            it("true를 반환한다.") {
                val result = balls.isBall(Ball(3), 2)
                result.shouldBeTrue()
            }
        }
        context("다른 위치에 다른 숫자가 주어지면") {
            it("false를 반환한다.") {
                val result = balls.isBall(Ball(4), 2)
                result.shouldBeFalse()
            }
        }
        context("같은 위치에 다른 숫자가 주어지면") {
            it("false를 반환한다.") {
                val result = balls.isBall(Ball(4), 1)
                result.shouldBeFalse()
            }
        }
        context("같은 위치에 같은 숫자가 주어지면") {
            it("false를 반환한다.") {
                val result = balls.isBall(Ball(3), 1)
                result.shouldBeFalse()
            }
        }
    }
})
