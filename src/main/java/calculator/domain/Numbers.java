package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers ;

    public Numbers(String[] strings) {
        if(Arrays.stream(strings).filter(s -> !s.isEmpty() && s.chars().anyMatch(Character::isDigit)).map(Integer::parseInt).anyMatch(integer -> integer<0)){
            throw new RuntimeException("음수가 입력되었습니다.");
        }
        this.numbers = Arrays.stream(strings).filter(s -> !s.isEmpty() && s.chars().allMatch(Character::isDigit)).map(Integer::parseInt).filter(integer -> integer>=0).collect(Collectors.toList());
    }

    public final List<Integer> getNumbers() {
        return numbers;
    }
}
