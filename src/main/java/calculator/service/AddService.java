package calculator.service;

import calculator.domain.Numbers;

public class AddService {
    public int addAll(Numbers numbers){
        return numbers.getNumbers().stream().mapToInt(i -> i).sum();
    }
}