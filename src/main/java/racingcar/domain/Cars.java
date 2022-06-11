package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.max;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void forwardAll(){
        carList.forEach(Car::forward);
    }

    public List<Integer> getLocations(){
        List<Integer> list = new ArrayList<>();
        carList.forEach(car -> list.add(car.getLocation()));
        return list;
    }

    public List<Car> rankCar() {
        int maxLocation = max(getLocations());
        return carList.stream().filter(car -> car.getLocation()==maxLocation).collect(Collectors.toList());
    }
}
