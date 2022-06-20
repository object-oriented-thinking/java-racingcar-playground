package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    @BeforeEach
    public void setUp(){
        cars = new Cars(new String[]{"ray", "audi", "benz", "tico"});
        cars.forwardAll();
    }

    @Test
    @DisplayName("우승 자동차의 이름 출력되는지 확인")
    public void getNameTest(){
        assertThat(cars.getMaxNames()).isNotNull();
    }
}
