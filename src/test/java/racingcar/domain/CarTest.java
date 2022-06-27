package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("5글자 초과시 Exception 발생 테스트")
    public void nameTest(){
        assertThatThrownBy(()-> new Car(new Name("sonata"))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진이 제대로 수행되는지 테스트")
    public void forwardTest(){
        Car car = new Car(new Name("jeep")){
            @Override
            protected int randomNumGenerator() {
                return 3;
            }
        };
        car.forward();
        assertThat(car.getLocation()).isEqualTo(new Location(0));
    }

    @Test
    @DisplayName("전진이 제대로 수행되는지 테스트2")
    public void forwardTest2(){
        Car car = new Car(new Name("jeep")){
            @Override
            protected int randomNumGenerator() {
                return 4;
            }
        };
        car.forward();
        assertThat(car.getLocation()).isEqualTo(new Location(1));
    }
}
