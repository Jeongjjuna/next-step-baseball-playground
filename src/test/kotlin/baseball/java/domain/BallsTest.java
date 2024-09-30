package baseball.java.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("[Balls 테스트]")
class BallsTest {

    @DisplayName("[create] 볼리스트 생성 시 Size 테스트")
    @Test
    void test1() {
        // given
        List<Integer> ballNums = List.of(1, 2, 3);

        // when & then
        assertDoesNotThrow(() -> Balls.create(ballNums));
    }

    @DisplayName("[create] 볼리스트 생성 시 Size 실패 테스트")
    @Test
    void test2() {
        // given
        List<Integer> ballNums1 = List.of(1, 2);
        List<Integer> ballNums2 = List.of(1, 2, 3, 4);


        // when & then
        assertThrows(IllegalArgumentException.class, () -> Balls.create(ballNums1));
        assertThrows(IllegalArgumentException.class, () -> Balls.create(ballNums2));
    }

    @DisplayName("[isThreeStrikeAgainst]")
    @Test
    void test3() {
        // given
        Balls balls = Balls.create(List.of(1, 2, 3));
        Balls otherBalls = Balls.create(List.of(1, 2, 3));

        // when
        int result = balls.countStrikeAgainst(otherBalls);

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("[countBallAgainst]")
    @Test
    void test4() {
        // given
        Balls balls = Balls.create(List.of(1, 2, 3));

        Balls otherBalls1 = Balls.create(List.of(3, 8, 9));
        Balls otherBalls2 = Balls.create(List.of(2, 3, 9));
        Balls otherBalls3 = Balls.create(List.of(3, 1, 2));

        // when
        int result1 = balls.countBallAgainst(otherBalls1);
        int result2 = balls.countBallAgainst(otherBalls2);
        int result3 = balls.countBallAgainst(otherBalls3);

        // then
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(3);

    }

    @DisplayName("[countStrikeAgainst]")
    @Test
    void test5() {
        // given
        Balls balls = Balls.create(List.of(1, 2, 3));

        Balls otherBalls1 = Balls.create(List.of(1, 2, 3));
        Balls otherBalls2 = Balls.create(List.of(1, 2, 9));
        Balls otherBalls3 = Balls.create(List.of(1, 8, 9));

        // when
        int result1 = balls.countStrikeAgainst(otherBalls1);
        int result2 = balls.countStrikeAgainst(otherBalls2);
        int result3 = balls.countStrikeAgainst(otherBalls3);

        // then
        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(1);
    }
}