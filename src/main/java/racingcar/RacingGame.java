package racingcar;

import java.util.Scanner;

public class RacingGame {

    public static final Scanner SCANNER = new Scanner(System.in);

    public void startGame() {
        System.out.println("이름 입력");
        RacingCars racingCars = new RacingCars(inputName());
        System.out.println("횟수 입력");
        int count = inputCount();
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            racingCars.startRacing();
            racingCars.printRacingStatus();
            System.out.println();
        }
        racingCars.printWinner();
    }

    public int inputCount() {
        int count = SCANNER.nextInt();
        if (count < 1) {
            throw new IllegalArgumentException();
        }
        return count;
    }

    public String inputName() {
        return SCANNER.nextLine();
    }
}
