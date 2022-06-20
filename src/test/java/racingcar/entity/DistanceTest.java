package racingcar.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @Test
    @DisplayName("자동차의 거리를 측정할 수 있다.")
    void test1() {
        //given
        Distance distance = new Distance();
        //when & then
        Assertions.assertThat(distance).isEqualTo(new Distance(0));
    }

    @Test
    @DisplayName("거리는 음수가 될 수 없다.")
    void test2() {
        //given
        int given = -2;
        //when & then
        Assertions.assertThatThrownBy(
            () -> new Distance(given)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동등한 경우 테스트")
    void test3() {
        //given
        int one = 1;
        Distance given = new Distance(one);
        //when & then
        assertThat(given.equals(new Distance(one))).isTrue();
    }

    @Test
    @DisplayName("동등하지 않은 경우 테스트")
    void test4() {
        //given
        Distance one = new Distance(1);
        //when
        Distance two = new Distance(2);
        //when & then
        assertThat(one.equals(two)).isFalse();
    }
}
