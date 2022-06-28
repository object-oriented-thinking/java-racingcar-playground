package game;

import game.storage.CarStorage;
import game.util.Util;

import java.util.Scanner;

public class Game {
    private final Scanner sc = new Scanner(System.in);
    private CarStorage carStorage;

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표를 기준으로 구분)");
        String[] splitCarNames = sc.nextLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = sc.nextInt();

        System.out.println("실행 결과");
        Util util = new Util(splitCarNames);
        ResultView resultView = new ResultView(splitCarNames,gameCount);

        while (gameCount > 0) {
            carStorage = util.addCarsToCarStorage();
            resultView.print(gameCount, carStorage);
            System.out.println("");
            gameCount--;
    }
        resultView.findWinner(splitCarNames,carStorage);
    }
}
