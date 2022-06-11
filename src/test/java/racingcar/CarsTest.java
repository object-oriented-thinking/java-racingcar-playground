package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    @BeforeEach
    public void setUp(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("ray"));
        carList.add(new Car("audi"));
        carList.add(new Car("benz"));
        carList.add(new Car("tico"));
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("모든 객체 전진 테스트")
    public void forwardAllTest(){
        cars.forwardAll();
        assertThat(cars.getLocations().stream().allMatch(integer -> integer>=0 && integer<=1)).isTrue();
    }

    @Test
    @DisplayName("랭킹 테스트")
    public void rankCarTest(){
        for(int i=0;i<3;i++){
            cars.forwardAll();
        }
        cars.rankCar().forEach(car -> System.out.println(car.getName()));
    }
}
