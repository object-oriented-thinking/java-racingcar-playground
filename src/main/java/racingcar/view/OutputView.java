package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public String locationToLine(int location){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<location;i++){
            result.append("-");
        }
        return result.toString();
    }

    public void outputCars(Cars cars){
        for(Car c: cars.getCarList()){
            System.out.print(c.getName()+" : ");
            System.out.println(locationToLine(c.getLocation()));
        }
        System.out.println();
    }

    public void resultCars(Cars cars){
        System.out.println(cars.getMaxNames()+"가 최종 우승했습니다.");
    }
}
