package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("처음 생성한 자동차의 이동 거리는 0이다.")
    void test1() {
        String carName = "car";
        RacingCar racingCar = new RacingCar(carName);
        assertAll(
            () -> assertThat(racingCar.getDistance()).isEqualTo(0),
            () -> assertThat(racingCar.getName()).isEqualTo(carName)
        );
    }

    @Test
    @DisplayName("자동차는 전진할 수 있다.")
    void test2() {
        //given
        RacingCar racingCar = new RacingCar("car");
        assertAll(
            () -> {
                //when
                racingCar.go();
                //then
                assertThat(racingCar.getDistance()).isEqualTo(1);
            },
            () -> {
                //when
                racingCar.go();
                //then
                assertThat(racingCar.getDistance()).isEqualTo(2);
            },
            () -> {
                //when
                racingCar.go();
                //then
                assertThat(racingCar.getDistance()).isEqualTo(3);
            }
        );
    }

    @Test
    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    void test3() {

        //given
        RacingCar racingCar = new RacingCar("car");

        assertAll(
            () -> {
                //when
                racingCar.racing();
                //then
                assertThat(racingCar.getDistance()).isBetween(0, 1);
            },
            () -> {
                //when
                racingCar.racing();
                //then
                assertThat(racingCar.getDistance()).isBetween(0, 2);
            },
            () -> {
                //when
                racingCar.racing();
                //then
                assertThat(racingCar.getDistance()).isBetween(0, 3);
            }
        );
    }

    @Test
    @DisplayName("움직인 결과를 출력한다.")
    void test4() {
        //given
        RacingCar racingCar = new RacingCar("name");
        //when
        racingCar.go();
        racingCar.go();
        racingCar.printRacingResult();
        //then
        assertThat("name : --").isEqualTo(outputStreamCaptor.toString().trim());
    }

}
