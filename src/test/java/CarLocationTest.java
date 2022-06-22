import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarLocationTest {

    @Test
    @DisplayName("랜덤값이 4이상일때 -가 하나 추가된다 : --출력")
    void location_MoreThan_2_Then_AddStringBuffer() {
        CarLocation carLocation = new CarLocation();
        StringBuffer stringCarLocation = carLocation.getCarLocation(4);
        assertEquals("--", stringCarLocation.toString());
    }

    @Test
    @DisplayName("랜덤값이 4미만일때는 초기값(-) 그대로를 출력한다 : -출력")
    void location_MoreLess_2_Then_InitStringBuffer() {
        CarLocation carLocation = new CarLocation();
        StringBuffer stringCarLocation = carLocation.getCarLocation(3);
        assertEquals("-", stringCarLocation.toString());
    }
}
