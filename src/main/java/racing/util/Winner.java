package racing.util;

import racing.storage.AdvanceCarStorage;

import static racing.util.Game.CAR_QUANTITY;

public class Winner {

    public static final int RANDOM_NUMBER_RANGE = 10;
    public static final int ADVANCE_COUNT = 4;
    private final AdvanceCarStorage advanceCarStorage;
    private final int winnerLocationLength;

    public Winner(AdvanceCarStorage advanceCarStorage) {
        this.advanceCarStorage = advanceCarStorage;
        this.winnerLocationLength = calculateMax();
    }

    public void checkWinner() {
        printCarName();
        findWinner();
    }

    private void findWinner() {
        findWinnerName();
        System.out.println("가 최종 우승했습니다");
    }

    private void findWinnerName() {
        for (int carCount = 0; carCount < CAR_QUANTITY; carCount++) {
            printWinnerName(carCount);
        }
    }

    private void printWinnerName(int carCount) {
        if (isWinnerLocationPoint(carCount)) {
            System.out.print(advancedCarName(carCount) + ", ");
        }
    }

    private boolean isWinnerLocationPoint(int carCount) {
        return advancedCarLocation(carCount).length() == this.winnerLocationLength;
    }

    private int calculateMax() {
        int max=0;
        for (int carCount = 0; carCount < CAR_QUANTITY; carCount++) {
            if (advancedCarLocation(carCount).length() > max) {
                max = advancedCarLocation(carCount).length();
            }
        }
        return max;
    }

    private void printCarName() {
        for (int carCount = 0; carCount < CAR_QUANTITY; carCount++) {
            System.out.println(advancedCarName(carCount) + " :  " + advancedCarLocation(carCount));
        }
    }

    private StringBuilder advancedCarLocation(int carCount) {
        return this.advanceCarStorage.getAdvancedCars().get(carCount).getLocation();
    }

    private String advancedCarName(int carCount) {
        return this.advanceCarStorage.getAdvancedCars().get(carCount).getName();
    }
}
