package baseball.domian

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.datatest.withData
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

@DisplayName("Ball 생성 테스트")
class BallTest : BehaviorSpec({

    data class InRangeData(val num: Int)

    withData(listOf("1~9 범위의 숫자가 주어졌을 때 Ball 클래스를 생성에 성공한다.")) {
        withData(
            InRangeData(1),
            InRangeData(5),
            InRangeData(9)
        ) { (num) ->
            shouldNotThrowAny {
                Ball.create(num)
            }
        }
    }

    data class OutRangeData(val num: Int)

    withData(listOf("1~9 범위가 아닌 숫가 주어졌을 때 예외가 발생한다.")) {
        withData(
            OutRangeData(0),
            OutRangeData(10),
            OutRangeData(999)
        ) { (num) ->
            val exception = shouldThrow<IllegalArgumentException> {
                Ball.create(num)
            }
            exception.message should startWith("[Error]")
        }
    }

})
