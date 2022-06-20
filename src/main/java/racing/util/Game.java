package racing.util;

import racing.domain.Car;
import racing.storage.AdvanceCarStorage;
import racing.storage.CarStorage;
import racing.storage.RandomNumberStorage;
import racing.validation.CarNameValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static racing.util.Winner.RANDOM_NUMBER_RANGE;

public class Game {

    public static final int CAR_QUANTITY = 3;
    private final Scanner scanner = new Scanner(System.in);
    private final List<Car> cars = new ArrayList<>();
    private final List<Integer> randomSelectedNumbers = new ArrayList<>();

    public void gameStart() {
        final CarStorage carCollectionsStorage = createCar(verifyCarNames(inputCarName()));
        int gameNumber = inputGameNumber();

        while (gameNumber>0) {
            final Advance advance = new Advance(generateRandomNumbers(), carCollectionsStorage);
            final AdvanceCarStorage advanceCarStorage = advance.checkAdvance();
            final Winner winner = new Winner(advanceCarStorage);

            winner.checkWinner();
            randomSelectedNumbers.clear();
            gameNumber--;
        }
    }

    public CarStorage createCar(String[] split) {
        addInputtedCars(split);
        return new CarStorage(cars);
    }

    private void addInputtedCars(String[] split) {
        for (int i = 0; i < CAR_QUANTITY; i++) {
            Car car = new Car(split[i], new StringBuilder().append("-"));
            cars.add(car);
        }
    }

    private String[] verifyCarNames(String[] inputtedCarNames) {
        CarNameValidation carNameValidation = new CarNameValidation();
        validationCarNames(inputtedCarNames, carNameValidation);
        return inputtedCarNames;
    }

    private int inputGameNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표를 기준으로 구분).");
        String line = scanner.nextLine();
        return line.split(",");
    }

    private RandomNumberStorage generateRandomNumbers() {
        while (isNotExceedNumberQuantity()) {
            int element = (int) (Math.random() * RANDOM_NUMBER_RANGE);
            randomSelectedNumbers.add(element);
        }
        return new RandomNumberStorage(randomSelectedNumbers);
    }

    private boolean isNotExceedNumberQuantity() {
        return this.randomSelectedNumbers.size() < CAR_QUANTITY;
    }

    private void validationCarNames(String[] inputtedCarNames, CarNameValidation carNameValidation) {
        for (String inputtedCarName : inputtedCarNames) {
            carNameValidation.checkCarName(inputtedCarName);
        }
    }
}
