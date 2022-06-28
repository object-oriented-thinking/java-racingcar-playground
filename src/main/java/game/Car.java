package game;

import java.util.regex.Pattern;

public class Car {
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z]*$");
    private static final int CAR_MAX_LENGTH = 5;
    private final String carName;
    private static final int ADVANCE_RANDOM_NUMBER = 4;
    private final StringBuffer stringLocation = new StringBuffer("-");

    public Car(String carName) {
        if (carName.length() > CAR_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자리를 넘을수 없다");
        }

        if (isNotMatchCarNamePattern(carName) || carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 영문만 올수있습니다");
        }

        this.carName = carName;
    }

    public StringBuffer advanceCarLocation(int randomNum) {
        if (randomNum >= ADVANCE_RANDOM_NUMBER) {
            return this.stringLocation.append("-");
        }
        return this.stringLocation;
    }

    public String getCarName() {
        return carName;
    }

    private boolean isNotMatchCarNamePattern(String carName) {
        return !CAR_NAME_PATTERN.matcher(carName).matches();
    }

    public StringBuffer getStringLocation() {
        return stringLocation;
    }
}
