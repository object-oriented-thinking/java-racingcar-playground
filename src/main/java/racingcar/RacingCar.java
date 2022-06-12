package racingcar;

import java.util.Random;

public class RacingCar {
    private static final int RANDOM_INTEGER = new Random().nextInt(10);
    private int distance;

    public RacingCar() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void decideGoOrNot() {
        if (RANDOM_INTEGER >= 4) {
            go();
        }
    }

    public void go() {
        this.distance++;
    }
}
