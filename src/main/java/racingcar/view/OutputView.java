package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public void outputCars(Cars cars){
        for(Car c: cars.getCarList()){
            System.out.print(c.getName().getName()+" : "+c.getLocation().makeBar()+"\n");
        }
        System.out.println();
    }

    public void resultCars(Cars cars){
        System.out.println(cars.getMaxNames()+"가 최종 우승했습니다.");
    }
}
