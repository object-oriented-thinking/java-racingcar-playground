package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    Car car;

    @Test
    @DisplayName("5글자 초과시 Exception 발생 테스트")
    public void nameTest(){
        String name = "sonata";
        assertThatThrownBy(()-> car = new Car(name)).isInstanceOf(RuntimeException.class);
    }

    @BeforeEach
    public void setUp(){
        String name = "jeep";
        car = new Car(name);
    }

    @Test
    @DisplayName("클래스가 제대로 생성되는지 테스트")
    public void nameTest2(){
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("랜덤 숫자가 0~9 사이인지 테스트")
    public void randomNumTest(){
        assertThat(car.randomNumGenerator()).matches(integer -> integer>=0 && integer<=9);
    }

    @Test
    @DisplayName("전진이 제대로 수행되는지 테스트")
    public void forwardTest(){
        car.forward();
        assertThat(car.getLocation()).isIn(0,1);
    }
}
