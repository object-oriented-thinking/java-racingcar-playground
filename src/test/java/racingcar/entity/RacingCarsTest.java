package racingcar.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("자동차의 리스트를 가지고 있다.")
    void test1() {
        //when & then
        Assertions.assertDoesNotThrow(
            () -> new RacingCars("pobi,crong,honux")
        );
    }

    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다. `pobi,crong,honux` 형태로 입력받는다.")
    void test2() {
        //when
        RacingCars racingCars = new RacingCars("pobi,crong,honux");
        //then
        assertThat(racingCars.getCars().size()).isEqualTo(3);
    }


    @Test
    @DisplayName("차동차의 이름이 하나라도 들어가지 않으면 IllegalArgumentException 예외가 발생한다.")
    void test3() {
        //when & then
        assertThatThrownBy(
            () -> new RacingCars("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름에는 문자열 외에는 들어가면 안된다.")
    void test10() {
        //when & then
        assertThatThrownBy(
            () -> new RacingCars("!pobi+crong,honux")
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("각 자동차에게 움직인 거리를 출력하게 한다.")
    void test5() {
        //given
        RacingCars racingCars = new RacingCars("pobi,crong,honux");
        //when
        racingCars.printRacingStatus();
        //then
        assertThat(outputStreamCaptor.toString()).isEqualTo("pobi : \ncrong : \nhonux : \n");
    }

    @Test
    @DisplayName("우승한 자동차 이름을 출력한다. 가장 많은 거리를 움직인 자동차가 우승이다.")
    void test6() {
        //given
        RacingCars racingCars = new RacingCars("pobi,crong,honux");
        //when
        racingCars.getCars().get(0).go();
        racingCars.printWinner();
        //then
        assertThat("pobi이(가) 최종 우승했습니다.").isEqualTo(outputStreamCaptor.toString());
    }

    @Test
    @DisplayName("우승자는 한명 이상일 수 있다.")
    void test7() {
        //given
        RacingCars racingCars = new RacingCars("pobi,crong,honux");
        //when
        racingCars.getCars().get(0).go();
        racingCars.getCars().get(1).go();
        racingCars.printWinner();
        //then
        assertThat("pobi, crong이(가) 최종 우승했습니다.").isEqualTo(outputStreamCaptor.toString());
    }

    @Test
    @DisplayName("자동차 이름이 고유해야 한다.")
    void test9() {

    }
}
