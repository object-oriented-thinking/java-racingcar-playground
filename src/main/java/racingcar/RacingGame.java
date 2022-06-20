package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public void startGame() {
        System.out.println("이름 입력");
        String carsNames = inputName();
        RacingCars racingCars = new RacingCars(carsNames);
        System.out.println("횟수 입력");
        int count = inputCount();
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            racingCars.printRacingStatus();
            racingCars.getCars().forEach(car -> car.racing(condition()));
            System.out.println();
        }
        racingCars.printWinner();
    }

    private boolean condition() {
        return RANDOM.nextInt(10) >= 4;
    }

    private int inputCount() {
        int count = SCANNER.nextInt();
        if (count < 1) {
            throw new IllegalArgumentException();
        }
        return count;
    }

    private String inputName() {
        return SCANNER.nextLine();
    }
}
