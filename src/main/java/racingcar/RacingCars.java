package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String REGEX = ",";
    private final List<RacingCar> racingCars;

    public RacingCars(String racingCarsNames) {

        if (racingCarsNames == null || racingCarsNames.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] strings = racingCarsNames.split(REGEX);

        this.racingCars = Arrays.stream(strings)
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public void printRacingStatus() {
        racingCars.forEach(RacingCar::printRacingStatus);
    }

    public void printWinner() {
        Comparator<RacingCar> carComparator = Comparator.comparingInt(RacingCar::getDistance);
        RacingCar topRankingCar = racingCars.stream().max(carComparator).orElseThrow(IllegalArgumentException::new);

        String carsName = racingCars.stream()
            .filter(racingCar -> topRankingCar.getDistance() == racingCar.getDistance())
            .map(RacingCar::getName)
            .reduce((s, s2) -> s + ", " + s2).orElseThrow(IllegalArgumentException::new);

        System.out.printf("%s이(가) 최종 우승했습니다.", carsName);
    }

    public void startRacing() {
        racingCars.forEach(RacingCar::racing);
    }
}
