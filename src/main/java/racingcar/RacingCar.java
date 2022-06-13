package racingcar;

import java.util.Random;

public class RacingCar {
    private static final Random RANDOM = new Random();

    private final String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;

    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void racing() {
        if (condition()) {
            go();
        }
    }

    public void printRacingResult() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < distance; i++) {
            stringBuffer.append("-");
        }
        System.out.printf("%s : %s", name, stringBuffer);
    }

    public boolean condition() {
        return RANDOM.nextInt(10) >= 4;
    }

    public void go() {
        this.distance++;
    }
}
