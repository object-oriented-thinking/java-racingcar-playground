package racing.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.storage.AdvanceCarStorage;
import racing.storage.CarStorage;
import racing.storage.RandomNumberStorage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AdvanceTest {

    Advance advance;
    Car car1 = new Car("testCar1",new StringBuilder().append("-"));
    Car car2 = new Car("testCar2",new StringBuilder().append("-"));
    Car car3 = new Car("testCar3",new StringBuilder().append("-"));

    @BeforeEach
    void setup() {
        List<Integer> random = Arrays.asList(0, 4, 9);
        List<Car> cars = Arrays.asList(car1, car2, car3);
        RandomNumberStorage randomNumberStorage = new RandomNumberStorage(random);
        CarStorage carStorage = new CarStorage(cars);
        advance = new Advance(randomNumberStorage,carStorage);
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void checkAdvanceTest() {
        AdvanceCarStorage advanceCarStorage = advance.checkAdvance();
        assertThat(advanceCarStorage.getAdvancedCars().get(0).getLocation()).contains("-");
        assertThat(advanceCarStorage.getAdvancedCars().get(1).getLocation()).contains("--");
        assertThat(advanceCarStorage.getAdvancedCars().get(2).getLocation()).contains("--");
    }
}