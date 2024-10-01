package baseball.java.domain;


import baseball.java.GameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("[Ball 테스트]")
class BallTest {

    @DisplayName("[create] 볼 생성 시 Range 테스트")
    @Test
    void test1() {
        // given
        int num = 1;

        // when & then
        assertDoesNotThrow(() -> Ball.create(1, 0));
    }

    @DisplayName("[create] 볼 생성 시 Range 실패 테스트")
    @Test
    void test2() {
        // given
        int invalidNum1 = 0;
        int invalidNum2 = 10;

        // when & then
        assertThrows(GameException.class, () -> Ball.create(invalidNum1, 0));
        assertThrows(GameException.class, () -> Ball.create(invalidNum2, 0));
    }

    @DisplayName("[isBall] 볼이 맞다면 true")
    @Test
    void test3() {
        // given
        Ball ball = new Ball(5, 1);

        Ball otherBall1 = new Ball(5, 0);
        Ball otherBall2 = new Ball(5, 2);

        // when & then
        assertAll(
                () -> assertThat(ball.isBall(otherBall1)).isTrue(),
                () -> assertThat(ball.isBall(otherBall2)).isTrue()
        );
    }

    @DisplayName("[isBall] 볼이 아니라면 false")
    @Test
    void test4() {
        // given
        Ball ball = new Ball(5, 1);

        Ball otherBall1 = new Ball(5, 1); // 스트라이크
        Ball otherBall2 = new Ball(6, 1); // 숫자가 다름
        Ball otherBall3 = new Ball(6, 1); // 숫자 다르고 위치는 같음

        // when & then
        assertAll(
                () -> assertThat(ball.isBall(otherBall1)).isFalse(),
                () -> assertThat(ball.isBall(otherBall2)).isFalse(),
                () -> assertThat(ball.isBall(otherBall3)).isFalse()
        );
    }

    @DisplayName("[isStrike] 스트라이크가 맞다면 true")
    @Test
    void test5() {
        // given
        Ball ball = new Ball(5, 1);
        Ball otherBall = new Ball(5, 1);

        // when
        boolean result = ball.isStrike(otherBall);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("[isStrike] 스트라이크가 아니라면 false")
    @Test
    void test6() {
        // given
        Ball ball = new Ball(5, 1);

        Ball otherBall1 = new Ball(5, 0); // 위치가 다름
        Ball otherBall2 = new Ball(8, 1); // 숫자가 다름
        Ball otherBall3 = new Ball(8, 0); // 위치, 숫자 모두 다름

        // when & then
        assertAll(
                () -> assertThat(ball.isStrike(otherBall1)).isFalse(),
                () -> assertThat(ball.isStrike(otherBall2)).isFalse(),
                () -> assertThat(ball.isStrike(otherBall3)).isFalse()
        );
    }
}