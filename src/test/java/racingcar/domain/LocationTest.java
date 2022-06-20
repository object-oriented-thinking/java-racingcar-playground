package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {
    Location l1 = new Location();
    Location l2 = new Location();

    @Test
    void forwardTest1(){
        l1.forward();
        l1.forward();
        assertThat(l1).isEqualTo(new Location(2));
    }

    @Test
    void forwardTest2(){
        assertThat(l2).isEqualTo(new Location(0));
    }

    @Test
    void compareTest(){
        assertThat(new Location(2).isGreaterThan(new Location(0))).isTrue();
        assertThat(new Location(1).isGreaterThan(new Location(2))).isFalse();
    }
}
