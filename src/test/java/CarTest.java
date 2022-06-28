import game.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자를 넘을수 없음")
    void carNameLength_IsExceed_Then_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputCarName("aaaaaaaa");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {" ","","a,   b,    c"})
    @DisplayName("자동차 이름은 공백이 포함될수 없음")
    void carName_isEmptyOrNull_Then_Exception(String carName) {
        assertThrows(IllegalArgumentException.class, () -> {
            inputCarName(carName);
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