package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NumberTest {

    @Test
    @DisplayName("Number에 입력되는 값은 음수가 들어가지 않는 0 이상의 숫자이다.")
    void test1() {
        assertDoesNotThrow(
            () -> new Number("9")
        );
    }

    @Test
    @DisplayName("음수를 전달하는 경우 RuntimeException 예외가 발생한다.")
    void test2() {
        assertThatThrownBy(
            () -> new Number("-1")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값을 전달하는 경우 NumberFormatException 예외가 발생한다.")
    void test2_2() {
        assertThatThrownBy(
            () -> new Number("not number")
        ).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("문자를 받아 숫자로 반환해 값을 저장한다.")
    void test3() {
        assertDoesNotThrow(
            () -> new Number("9")
        );
    }

    @Test
    @DisplayName("공백이 들어오게 되면 0으로 저장한다.")
    void test4() {
        Number number = new Number("");
        assertThat(number).isEqualTo(new Number("0"));
    }

    @Test
    @DisplayName("자신의 숫자와 다음 숫자의 값을 더한다.")
    void test5() {
        //given
        Number four = new Number("4");
        Number five = new Number("5");

        //when
        Number result = four.addNumber(five);

        //then
        Number nine = new Number("9");
        assertThat(result).isEqualTo(nine);

    }

    @Test
    @DisplayName("동등성 비교")
    void test6() {
        Number nine = new Number("9");
        assertThat(nine).isEqualTo(new Number("9"));
    }

    @Test
    @DisplayName("같지 않을 경우 비교")
    void test7() {
        Number nine = new Number("9");
        Number eleven = new Number("11");
        assertThat(nine).isNotEqualTo(eleven);
    }
}
