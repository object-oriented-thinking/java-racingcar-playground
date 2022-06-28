package game;

import game.storage.CarStorage;

public class ResultView {
    private int max =0;
    private final int initialGameCountValue;
    private final StringBuffer answer = new StringBuffer("");
    private final String[] split;

    public ResultView(String[] split, int initialGameCountValue) {
        this.split = split;
        this.initialGameCountValue = initialGameCountValue;
    }

    public void print(int gameCount, CarStorage carStorage) {
        for (int i = 0; i < split.length; i++) {
            if (initialGameCountValue == gameCount) {
                System.out.println(carStorage.getCarName(i) + " : " + carStorage.getNotAdvanceCar(i));
                continue;
            }
            System.out.println(carStorage.getCarName(i) + " : " + carStorage.getAdvanceCar(i));
            calculateMaxValue(carStorage, i);
        }
    }

    public void findWinner(String[] split, CarStorage carStorage) {
        for (int i = 0; i < split.length; i++) {
            if (isWinnerLength(carStorage, i)) {
                answer.append(carStorage.getCarName(i));
            }
        }
        printWinner();
    }

    private void calculateMaxValue(CarStorage carStorage, int i) {
        if (isOverMaxLocation(carStorage, i)) {
            max= carStorage.getNotAdvanceCar(i).length();
        }
    }

    private boolean isOverMaxLocation(CarStorage carStorage, int i) {
        return carStorage.getNotAdvanceCar(i).length() > max;
    }

    private void printWinner() {
        for (int i = 0; i < answer.length(); i++) {
            System.out.print(answer.charAt(i));
            if (isNotFinalSequence(i)) {
                System.out.print(",");
            }
        }
        System.out.print("가 최종 우승했습니다");
    }

    private boolean isNotFinalSequence(int i) {
        return i != answer.length() - 1;
    }

    private boolean isWinnerLength(CarStorage carStorage, int i) {
        return carStorage.getNotAdvanceCar(i).length() == max;
    }
}
