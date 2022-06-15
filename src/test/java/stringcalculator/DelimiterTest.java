package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DelimiterTest {

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:), 그리고 커스텀 구분자를 가진다.")
    void test1() {
        assertDoesNotThrow(() -> new Delimiter(";"));
    }

    @Test
    @DisplayName("그 외 문자나 기호로 비교할 경우 IllegalArgumentException 예외가 발생한다.")
    void test2() {
        Delimiter delimiter = new Delimiter("(");
        assertThatThrownBy(
            () -> delimiter.compareTo("+")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자가 없으면 기존 쉼표와 콜론으로 식을 해결한다.")
    void test3() {
        Delimiter delimiter = new Delimiter();
        assertThat(delimiter.compareTo(":")).isTrue();
    }
}
