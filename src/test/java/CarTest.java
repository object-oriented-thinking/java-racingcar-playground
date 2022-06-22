import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자를 넘을수 없음")
    void carNameLength_IsExceed_Then_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputCarName("aaaaaaaa");
        });
    }

    @Test
    @DisplayName("자동차 이름은 공백이거나 null 일수 없음")
    void carName_isEmptyOrNull_Then_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputCarName(" ");
            inputCarName(null);
            inputCarName("");
            inputCarName("a,   b,    c");
        });
    }

    @Test
    @DisplayName("자동차 이름엔 특수문자가 들어갈수 없음")
    void carName_Include_SpecialCharacters_Then_Exception() {
        assertThrows(IllegalArgumentException.class, () ->{
            inputCarName("!@#$");
        });
    }

    private void inputCarName(String carName) {
        Car car = new Car(carName);
    }
}