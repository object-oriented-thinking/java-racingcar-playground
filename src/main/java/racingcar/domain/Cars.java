package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.max;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public void addCar(Car car){
        this.carList.add(car);
    }

    public void forwardAll(){
        carList.forEach(Car::forward);
    }

    public int maxLocation(){
        return max(carList.stream().map(Car::getLocation).collect(Collectors.toList()));
    }

    public String getMaxNames(){
        List<String> result = new ArrayList<>();
        for(Car c: carList){
            if(c.getLocation()==maxLocation()){
                result.add(c.getName());
            }
        }
        if(!result.isEmpty()){
            return String.join(",", result);
        }
        throw new RuntimeException("최대로 이동한 자동차를 찾을 수 없습니다.");
    }

    public List<Car> getCarList(){
        return carList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
