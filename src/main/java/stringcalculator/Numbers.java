package stringcalculator;

import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public int getResult() {
        return numbers
            .stream()
            .reduce(Number::addNumber)
            .orElseThrow(RuntimeException::new)
            .getNumber();
    }
}
