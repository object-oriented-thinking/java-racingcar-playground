package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.max;

public class Cars {
    private final List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void add(Car car){
        this.carList.add(car);
    }

    public void forwardAll(){
        carList.forEach(Car::forward);
    }

    public int maxLocation(){
        return max(carList.stream().map(Car::getLocation).collect(Collectors.toList()));
    }

    public String getMaxNames(){
        StringBuilder result = new StringBuilder();
        for(Car c: carList){
            if(c.getLocation()==maxLocation()){
                result.append(c.getName()).append(", ");
            }
        }
        if(result.length() > 0){
            return result.substring(0, result.length()-2);
        }
        else {
            throw new RuntimeException("최대로 이동한 자동차를 찾을 수 없습니다.");
        }
    }

    public List<Car> getCarList(){
        return carList;
    }
}
