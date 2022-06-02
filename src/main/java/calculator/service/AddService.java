package calculator.service;

import java.util.Arrays;

public class AddService {
    public boolean containsNeg(String[] numbers){
        return !Arrays.stream(numbers).map(Integer::parseInt).allMatch(integer -> integer >= 0);
    }

    public int addAll(String[] numbers){
        return Arrays.stream(numbers).map(Integer::parseInt).mapToInt(i -> i).sum();
    }
}
