package racingcar.util;

import java.util.Random;

public class MovingStrategyImpl implements MovingStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean condition() {
        return RANDOM.nextInt(10) >= 4;
    }
}
