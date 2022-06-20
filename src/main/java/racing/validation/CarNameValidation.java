package racing.validation;

import java.util.regex.Pattern;

public class CarNameValidation {

    public static final int LIMIT_CARNAME_LENGTH = 5;
    public static final String CARNAME_PATTERN = "^[a-zA-Z]*$";

    public void checkCarName(String carName) {
        if (isExceedCarNameLength(carName)) {
            throw new IllegalArgumentException("자동차의 이름길이를 초과했습니다.");
        }

        if (isNotMatchingCarNamePattern(carName)) {
            throw new IllegalArgumentException("자동차의 이름패턴을 확인해주세요");
        }
    }

    private boolean isNotMatchingCarNamePattern(String carName) {
        return !Pattern.matches(CARNAME_PATTERN, carName);
    }

    private boolean isExceedCarNameLength(String carName) {
        return carName.length() > LIMIT_CARNAME_LENGTH;
    }
}
