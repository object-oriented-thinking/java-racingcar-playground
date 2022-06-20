package racingcar;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {

    private static final Random RANDOM = new Random();

    private final Name name;
    private Distance distance;

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance(0);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public void racing() {
        if (condition()) {
            go();
        }
    }

    public void racing(boolean condition) {
        if (condition) {
            go();
        }
    }

    public void printRacingStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < distance.getDistance(); i++) {
            stringBuilder.append("-");
        }
        System.out.printf("%s : %s\n", name.getName(), stringBuilder);
    }

    public void go() {
        this.distance = new Distance(distance.getDistance() + 1);
    }

    private boolean condition() {
        return RANDOM.nextInt(10) >= 4;
    }
}
