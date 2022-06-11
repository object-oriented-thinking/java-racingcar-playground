package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    @BeforeEach
    public void setUp(){
        cars = new Cars();
        cars.add(new Car("ray"));
        cars.add(new Car("audi"));
        cars.add(new Car("benz"));
        cars.add(new Car("tico"));
        cars.forwardAll();
    }

    @Test
    @DisplayName("max 값이 정상적으로 도출되는지 확인")
    public void maxTest(){
        assertThat(cars.maxLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승 자동차의 이름 출력되는지 확인")
    public void getNameTest(){
        assertThat(cars.getMaxNames()).isNotNull();
    }

}
