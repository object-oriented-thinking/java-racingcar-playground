package game.storage;

import game.Car;

import java.util.Collections;
import java.util.List;

import static game.util.Util.generateRandomNumber;

public class CarStorage {

    private final List<Car> cars;

    public CarStorage(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getCarName(int number) {
        return getCars().get(number).getCarName();
    }

    public StringBuffer getAdvanceCar(int number) {
        return getCars().get(number).advanceCarLocation(generateRandomNumber());
    }

    public StringBuffer getNotAdvanceCar(int number) {
        return getCars().get(number).getStringLocation();
    }
}
