package racing.storage;

import racing.domain.Car;

import java.util.List;

public class AdvanceCarStorage {

    private final List<Car> advancedCars;

    public AdvanceCarStorage(List<Car> advancedCars) {
        this.advancedCars = advancedCars;
    }

    public List<Car> getAdvancedCars() {
        return advancedCars;
    }
}
