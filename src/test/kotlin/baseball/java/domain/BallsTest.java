package baseball.java.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("[Balls 테스트]")
class BallsTest {

    @DisplayName("볼리스트 생성 시 Size 테스트")
    @Test
    void test1() {
        // given
        List<Integer> ballNums = List.of(1, 2, 3);

        // when & then
        assertDoesNotThrow(() -> Balls.create(ballNums));
    }

    @DisplayName("볼리스트 생성 시 Size 실패 테스트")
    @Test
    void test2() {
        // given
        List<Integer> ballNums1 = List.of(1, 2);
        List<Integer> ballNums2 = List.of(1, 2, 3, 4);


        // when & then
        assertThrows(IllegalArgumentException.class, () -> Balls.create(ballNums1));
        assertThrows(IllegalArgumentException.class, () -> Balls.create(ballNums2));
    }

}