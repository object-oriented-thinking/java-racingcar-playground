package calculator.service;

import calculator.domain.Numbers;

public class AddService {
    public boolean containsNegative(Numbers numbers){
        return !numbers.getNumbers().stream().allMatch(integer -> integer >= 0);
    }

    public int addAll(Numbers numbers){
        return numbers.getNumbers().stream().mapToInt(i -> i).sum();
    }
}
