package racingcar;

import racingcar.entity.RacingCars;
import racingcar.util.*;

public class RacingMain {

    private static final InputClient inputClient = new InputClientImpl();
    private static final MovingStrategy movingStrategy = new MovingStrategyImpl();

    public static void main(String[] args) {
        System.out.println("이름 입력");
        String carsNames = inputClient.inputName();
        RacingGame racingGame = new RacingGame(carsNames);

        System.out.println("횟수 입력");
        int count = inputClient.inputCount();

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            racingGame.printRacingStatus();
            racingGame.moveCars(movingStrategy);
            System.out.println();
        }

        racingGame.printWinner();
    }

}
