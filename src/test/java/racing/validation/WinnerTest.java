package racing.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.storage.CarStorage;
import racing.util.Game;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    private final Game game = new Game();
    CarStorage car;

    @BeforeEach
    void setup() {
        String[] split = getCarNames();
        car = game.createCar(split);
    }

    @Test
    @DisplayName("입력한 자동차 이름 테스트")
    void carCacheTest() {
        assertThat(car.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(car.getCars().get(1).getName()).isEqualTo("crong");
        assertThat(car.getCars().get(2).getName()).isEqualTo("honux");
    }

    private String[] getCarNames() {
        String input = "pobi,crong,honux";
        return input.split(",");
    }
}
