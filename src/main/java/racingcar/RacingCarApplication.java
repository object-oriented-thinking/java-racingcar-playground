package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Cars cars = inputView.makeCars();
        int tries = inputView.getTries();

        System.out.println("실행 결과");
        for(int i=0;i<tries;i++){
            cars.forwardAll();
            outputView.outputCars(cars);
        }

        outputView.resultCars(cars);
    }
}
