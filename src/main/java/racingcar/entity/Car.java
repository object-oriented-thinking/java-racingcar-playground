package racingcar.entity;

import java.util.Random;

public class Car {
    private final Name name;
    private Distance distance;

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
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
}
