package racing.storage;

import java.util.List;

public class RandomNumberStorage {

    private final List<Integer> randomSelectedNumbers;

    public RandomNumberStorage(List<Integer> numbers) {
        this.randomSelectedNumbers = numbers;
    }

    public List<Integer> getRandomSelectedNumbers() {
        return randomSelectedNumbers;
    }
}
