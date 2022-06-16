import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("입력이 null 이나 공백이면 0을반환한다")
    void checkNullOrEmpty() {
        assertThat(calculator.add((null))).isEqualTo(0);
        assertThat(calculator.add((""))).isEqualTo(0);
        assertThat(calculator.add(("1123"))).isNotEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할경우 해당숫자를 반환한다")
    void checkOneNumber() {
        assertThat(calculator.add("1")).isEqualTo(1);
        assertThat(calculator.add("11")).isEqualTo(11);
    }

    @Test
    @DisplayName("음수 입력시에 RuntimeExcpetion 예외 발생한다")
    void checkNegativeNumber() {
        assertThrows(RuntimeException.class, () ->{
            calculator.add("-1,2,3");
        });
    }

    @Test
    @DisplayName("숫자 두개를 컴마로 구분할경우 합을반환한다")
    void addTwoNumber() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 컴마로 구분할경우 합을반환한다")
    void addTwoNumber2() {
        assertThat(calculator.add("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용할수있다")
    void customSeparateTest2() {
        assertThat(calculator.add("//:\n1:2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("컴마와 콜론을 구분자로 사용할수있다")
    void useCommaOrColon() {
        assertThat(calculator.add("1,2;3")).isEqualTo(6);
    }
}