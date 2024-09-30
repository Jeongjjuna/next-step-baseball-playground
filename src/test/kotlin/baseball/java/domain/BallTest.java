package baseball.java.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("[Ball 테스트]")
class BallTest {

    @DisplayName("볼 생성 시 Range 테스트")
    @Test
    void test1() {
        // given
        int num = 1;

        // when & then
        assertDoesNotThrow(() -> Ball.create(1, 0));
    }

    @DisplayName("볼 생성 시 Range 실패 테스트")
    @Test
    void test2() {
        // given
        int invalidNum1 = 0;
        int invalidNum2 = 10;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Ball.create(invalidNum1, 0));
        assertThrows(IllegalArgumentException.class, () -> Ball.create(invalidNum2, 0));
    }
}