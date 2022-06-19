package calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(String[] strings) {
        if(Arrays.stream(strings).filter(s -> !s.trim().isEmpty() && s.chars().anyMatch(Character::isDigit)).map(Integer::parseInt).anyMatch(integer -> integer<0)){
            throw new RuntimeException("음수가 입력되었습니다.");
        }
        this.numbers = Arrays.stream(strings).filter(s -> !s.trim().isEmpty()).map(Integer::parseInt).collect(Collectors.toList());
    }

    public  List<Integer> getNumbers() {
        return numbers.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
