package baseball.java.domain;

import baseball.java.GameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("[UserAction 테스트]")
class UserActionTest {

    @DisplayName("유효하지 않은 UserActions 생성 테스트")
    @Test
    void test1() {
        // given
        String invalidInput1 = "999999";
        String invalidInput2 = "134&^%^";

        // when & then
        assertThrows(GameException.class,() -> UserAction.create(invalidInput1));
        assertThrows(GameException.class, () -> UserAction.create(invalidInput2));
    }
}