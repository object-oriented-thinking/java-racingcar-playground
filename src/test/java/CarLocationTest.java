import game.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarLocationTest {

    Car car = new Car("pobi");

    @Test
    @DisplayName("랜덤값이 4이상일때 -가 하나 추가된다 : --출력")
    void location_MoreThan_2_Then_AddStringBuffer() {
        assertEquals("--",car.advanceCarLocation(4).toString() );
    }

    @Test
    @DisplayName("랜덤값이 4미만일때는 초기값(-) 그대로를 출력한다 : -출력")
    void location_MoreLess_2_Then_InitStringBuffer() {
        assertEquals("-", car.advanceCarLocation(3).toString());
    }
}
