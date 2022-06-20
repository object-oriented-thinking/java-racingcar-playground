package racingcar;

import racingcar.util.InputClient;
import racingcar.util.InputClientImpl;
import racingcar.util.RacingGame;

public class RacingMain {
    private static final InputClient inputClient = new InputClientImpl();

    public static void main(String[] args) {
        System.out.println("이름 입력");
        String carsNames = inputClient.inputName();
        RacingGame racingGame = new RacingGame(carsNames);

        System.out.println("횟수 입력");
        int count = inputClient.inputCount();

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            racingGame.moveCars();
            racingGame.printRacingStatus();
            System.out.println();
        }

        racingGame.printWinner();
    }

}
