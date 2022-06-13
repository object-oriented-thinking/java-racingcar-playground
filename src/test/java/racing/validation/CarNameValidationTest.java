package racing.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameValidationTest {

    private final CarNameValidation carNameValidation = new CarNameValidation();

    @Test
    @DisplayName("자동차 이름은 5자리를 초과할수없다")
    void carNameLengthTest() {
        String input = "123451234,ㅁㄴㅇㄿㅊㅋㅌㅍ";
        String[] split = input.split(",");
        assertThrows(IllegalArgumentException.class, () ->{
            carNameValidation.checkCarName(split[0]);
            carNameValidation.checkCarName(split[1]);
        });
    }

    @Test
    @DisplayName("자동차 이름은 영문만 와야한다")
    void notOnlyEnglishNameTest() {
        String input = "     ,12345,가나다라마,' '";
        String[] split = input.split(",");
        assertThrows(IllegalArgumentException.class, () ->{
           carNameValidation.checkCarName(split[0]);
           carNameValidation.checkCarName(split[1]);
           carNameValidation.checkCarName(split[2]);
           carNameValidation.checkCarName(split[3]);
        });
    }
}