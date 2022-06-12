package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    @Test
    @DisplayName("처음 생성한 자동차의 이동 거리는 0이다.")
    void test1() {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 전진할 수 있다.")
    void test2() {
        //given
        RacingCar racingCar = new RacingCar();
        //when
        racingCar.go();
        //then
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    void test3() {
        //given
        RacingCar racingCar = new RacingCar();
        //when & then
        racingCar.decideGoOrNot();
        assertThat(racingCar.getDistance()).isBetween(0, 1);
        //when & then
        racingCar.decideGoOrNot();
        assertThat(racingCar.getDistance()).isBetween(0, 2);
        //when & then
        racingCar.decideGoOrNot();
        System.out.println((racingCar.getDistance()));
        assertThat(racingCar.getDistance()).isBetween(0, 3);

    }
}
