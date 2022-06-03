package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(String[] strings) {
        this.numbers = Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
