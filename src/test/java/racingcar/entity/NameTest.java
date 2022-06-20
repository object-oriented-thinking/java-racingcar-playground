package racingcar.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("자동차에 이름을 입력할 수 있다.")
    void test0() {
        //given
        Name name = new Name("tis");
        //when & then
        assertThat(name.getName()).isEqualTo("tis");
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과하면 IllegalArgumentException 예외를 발생한다.")
    void test1() {
        //when & then
        assertThatThrownBy(
            () -> new Name("longName")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름에 특수문자가 들어가면 IllegalArgumentException 예외를 발생한다.")
    void test2() {
        //when & then
        assertThatThrownBy(
            () -> new Name("ka!")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동등한 경우 테스트")
    void test3() {
        //given
        Name given = new Name("tis");
        //when & then
        assertThat(given.equals(new Name("tis"))).isTrue();
    }

    @Test
    @DisplayName("동등하지 않은 경우 테스트")
    void test4() {
        //given
        Name given = new Name("tis");
        //when & then
        assertThat(given.equals(new Name("noTis"))).isFalse();
    }
}
