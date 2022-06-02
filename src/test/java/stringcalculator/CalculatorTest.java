package stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    @DisplayName("문자열을 가져온다.")
    void test1() {
        Assertions.assertDoesNotThrow(
            () -> new Calculator("1,2,3")
        );
    }

    @Test
    @DisplayName("커스텀 구분자는 문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    void test2() {
        String customDelimiter = "+";
        Calculator given = new Calculator("//" + customDelimiter + "\n1+2,3");
        assertThat(given.getResult()).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열에는 지정된 문자와 숫자가 아니면 RuntimeException 예외가 발생한다.")
    void test3() {
        String customDelimiter = "+";
        assertThatThrownBy(
            () -> new Calculator("//" + customDelimiter + "\n1-2,3")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("식을 계산한다.")
    void test4() {
        //given
        Calculator given = new Calculator("1,2,3");
        int expected = 6;
        //when & then
        assertThat(given.getResult()).isEqualTo(expected);
    }


    @Test
    @DisplayName("빈 값을 다 더하면 0이다")
    void test5() {
        Calculator given = new Calculator(",,");
        int expected = 0;
        //when & then
        assertThat(given.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("중간에만 값이 들어가는 경우에도 계산이 된다.")
    void test6() {
        Calculator given = new Calculator(",1,");
        int expected = 1;
        //when & then
        assertThat(given.getResult()).isEqualTo(expected);
    }
}
