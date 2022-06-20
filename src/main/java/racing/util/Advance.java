package racing.util;

import racing.domain.Car;
import racing.storage.AdvanceCarStorage;
import racing.storage.CarStorage;
import racing.storage.RandomNumberStorage;

import java.util.ArrayList;
import java.util.List;

import static racing.util.Game.CAR_QUANTITY;
import static racing.util.Winner.ADVANCE_COUNT;

/**
 * 자동차의 전진내용과 관련된 클래스
 */
public class Advance {

    private final RandomNumberStorage randomNumberStorage;
    private final CarStorage carStorage;
    private final List<Car> advancedCarsList = new ArrayList<>();

    public Advance(RandomNumberStorage randomNumberStorage, CarStorage carStorage) {
        this.randomNumberStorage = randomNumberStorage;
        this.carStorage = carStorage;
    }

    public AdvanceCarStorage checkAdvance() {
        addCarList();
        return new AdvanceCarStorage(advancedCarsList);
    }

    private void addCarList() {
        for (int carCount = 0; carCount < CAR_QUANTITY; carCount++) {
            if (isAdvance(carCount)) continue;
            addThatIsNotAdvanceCars(carCount);
        }
    }

    private void addThatIsNotAdvanceCars(int carCount) {
        Car car = new Car(getCarStorageNames(carCount), getCarStorageLocations(carCount));
        advancedCarsList.add(car);
    }

    private StringBuilder getCarStorageLocations(int carCount) {
        return carStorage.getCars().get(carCount).getLocation();
    }

    private String getCarStorageNames(int carCount) {
        return carStorage.getCars().get(carCount).getName();
    }

    private boolean isAdvance(int carCount) {
        if (isMatchAdvanceCount(carCount)) {
            Car car = new Car(getCarStorageNames(carCount), getCarStorageLocations(carCount).append("-"));
            advancedCarsList.add(car);
            return true;
        }

        return false;
    }

    private boolean isMatchAdvanceCount(int carCount) {
        return this.randomNumberStorage.getRandomSelectedNumbers().get(carCount) >= ADVANCE_COUNT;
    }
}
