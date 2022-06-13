package racingcar;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingCar {
    private static final String REGEX = "[^a-zA-Z\\d]";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final Random RANDOM = new Random();

    private final String name;
    private int distance;

    public RacingCar(String name) {
        Matcher m = PATTERN.matcher(name);

        if (m.matches()) {
            throw new IllegalArgumentException("특수문자는 안됩니다.");
        }

        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("길이는 5 이하이어야 합니다.");
        }

        this.name = name.trim();
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

    public void printRacingStatus() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < distance; i++) {
            stringBuffer.append("-");
        }
        System.out.printf(" %s : %s\n", name, stringBuffer);
    }

    public boolean condition() {
        return RANDOM.nextInt(10) >= 4;
    }

    public void go() {
        this.distance++;
    }
}
