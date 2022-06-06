package stringcalculator;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(String stringNumber) {
        int number;

        if (stringNumber.trim().isEmpty()) {
            this.number = 0;
            return;
        }

        number = Integer.parseInt(stringNumber);

        if (number < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }

        this.number = number;
    }

    public Number addNumber(Number number) {
        return new Number(String.valueOf(this.number + number.number));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
