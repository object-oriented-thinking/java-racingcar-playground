package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(String[] strings) {
        for (String s : strings) {
            Name name = new Name(s);
            carList.add(new Car(name));
        }
    }

    public void forwardAll() {
        carList.forEach(Car::forward);
    }

    public Location maxLocation() {
        Location location = new Location();
        for (Car c : carList) {
            if (c.getLocation().isGreaterThan(location)) {
                location = c.getLocation();
            }
        }
        return location;
    }

    public String getMaxNames() {
        List<String> result = new ArrayList<>();
        for (Car c : carList) {
            if (c.getLocation().equals(maxLocation())) {
                result.add(c.getName().getName());
            }
        }
        if (!result.isEmpty()) {
            return String.join(",", result);
        }
        throw new RuntimeException("최댓값을 가진 이름을 반환할 수 없습니다");
    }

    public List<Car> getCarList() {
        return carList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
