import java.util.regex.Pattern;

public class Car {
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z]*$");
    private static final int CAR_MAX_LENGTH = 5;
    private final String carName;
    private final int randomNum;

    public Car(String carName) {
        if (carName.length() > CAR_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자리를 넘을수 없다");
        }

        if (isNotMatchingCarNamePattern(carName)) {
            throw new IllegalArgumentException("자동차 이름은 영문만 올수있습니다");
        }

        this.carName = carName;
        this.randomNum = generateRandomNumber();
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private boolean isNotMatchingCarNamePattern(String carName) {
        return !CAR_NAME_PATTERN.matcher(carName).matches();
    }

    public int getRandomNum() {
        return randomNum;
    }

    public String getCarName() {
        return carName;
    }
}
