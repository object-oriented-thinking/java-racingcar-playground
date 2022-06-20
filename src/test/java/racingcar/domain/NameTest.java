package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("Name 5글자 이상일 경우 예외 발생 테스트")
    void checkValid1(){
        assertThatThrownBy(() -> new Name("giant")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("Name 비어있을 경우 예외 발생 테스트")
    void checkValid2(){
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("Name 비어있을 경우 예외 발생 테스트2")
    void checkValid3(){
        assertThatThrownBy(() -> new Name("  ")).isInstanceOf(IllegalArgumentException.class);
    }
}
