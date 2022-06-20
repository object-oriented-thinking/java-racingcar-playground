package racingcar.util;

import racingcar.entity.RacingCars;

public class RacingGame {

    private static final MovingStrategy movingStrategy = new MovingStrategyImpl();

    private RacingCars racingCars;

    public RacingGame(String carsNames) {
        this.racingCars = new RacingCars(carsNames);
        ;
    }

    public void printRacingStatus() {
        this.racingCars.printRacingStatus();
    }

    public void moveCars() {
        this.racingCars.getCars().forEach(car -> car.racing(movingStrategy.condition()));
    }

    public void printWinner() {
        racingCars.printWinner();
    }
}
