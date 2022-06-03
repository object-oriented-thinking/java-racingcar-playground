package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(String[] strings) {
        this.numbers = Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());
        checkNegative();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void checkNegative(){
        if(!this.numbers.stream().allMatch(integer -> integer >= 0)){
            throw new RuntimeException("음수가 전달되었습니다");
        }
    }
}
