package game.util;

import game.Car;
import game.storage.CarStorage;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private final String[] split;
    private final List<Car> cars = new ArrayList<>();

    public Util(String[] split) {
        this.split = split;
    }

    public CarStorage addCarsToCarStorage() {
        for (String s : this.split) {
            Car car = new Car(s);
            cars.add(car);
        }
        return new CarStorage(cars);
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
