package baseball.domian

import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

@DisplayName("[단위테스트] GameStatus")
class GameStatusTest : DescribeSpec({

    describe("increaseStrike() 테스트") {
        context("메서드가 호출되면") {
            val gameStatus = GameStatus(0, 0)
            it("strike가 1증가한다.") {
                gameStatus.increaseStrike()
                gameStatus.strike shouldBe 1
            }
        }
    }

    describe("increaseBall() 테스트") {
        context("메서드가 호출되면") {
            val gameStatus = GameStatus(0, 0)
            it("ball이 1증가한다.") {
                gameStatus.increaseBall()
                gameStatus.ball shouldBe 1
            }
        }
    }

    describe("isNothing() 테스트") {
        context("strike == 0, ball == 0이면") {
            val gameStatus = GameStatus(0, 0)
            it("true를 반환한다.") {
                val result = gameStatus.isNothing()
                result.shouldBeTrue()
            }
        }
        context("strike >= 1 혹은 ball >= 0이면") {
            val input = listOf(GameStatus(1, 0), GameStatus(0, 1))
            it("false를 반환한다.") {
                input.forAll { gameStatus ->
                    val result = gameStatus.isNothing()
                    result.shouldBeFalse()
                }

            }
        }
    }

    describe("isGameOver() 테스트") {
        context("strike가 3이면") {
            val gameStatus = GameStatus(3, 0)
            it("true를 반환한다.") {
                val result = gameStatus.isGameOver()
                result.shouldBeTrue()
            }
        }

        context("strike가 3이 아니면") {
            val gameStatus = GameStatus(2, 0)
            it("true를 반환한다.") {
                val result = gameStatus.isGameOver()
                result.shouldBeFalse()
            }
        }
    }

})