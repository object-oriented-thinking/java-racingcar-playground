import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private final List<Car> cars = new ArrayList<>();
    private final List<CarLocation> carLocationArrayList = new ArrayList<>();
    private CarStorage carStorage;
    private List<StringBuffer> winners = new ArrayList<>();


    public void gameStart() {
        String[] split = getCarNames();
        int gameCount = getGameCount();
        int tmp = gameCount;
        int max = 0;

        while (gameCount > 0) {
            carStorage = inputCars(split); // 자동차 3개를 입력받은 이름을 가지고 생성해서 일급컬렉션에 저장한다
            for (int loopCount = 0; loopCount < split.length; loopCount++) {
                if (gameCount == tmp) {
                    CarLocation carLocation = new CarLocation();
                    carLocationArrayList.add(carLocation);
                    System.out.println(carStorage.getCars().get(loopCount).getCarName() + " : " + carLocationArrayList.get(0).getStringLocation());
                } else {
                    System.out.println(carStorage.getCars().get(loopCount).getCarName() + " : " + carLocationArrayList.get(loopCount).getCarLocation(getRandomNumber(loopCount)) );
                }

            }
            for (int i = 0; i < split.length; i++) {
                if (max < carLocationArrayList.get(i).getStringLocation().length()) {
                    max = carLocationArrayList.get(i).getStringLocation().length();
                }
            }

            cars.clear();
            gameCount--;
        }

        for (int i = 0; i < split.length; i++) {
            if (carLocationArrayList.get(i).getStringLocation().length() == max) {
                System.out.printf("%s",carStorage.getCars().get(i).getCarName()+ ", ");
            }
        }
        System.out.print("가 최종 우승했습니다");
    }

    private int getRandomNumber(int i) {
        return carStorage.getCars().get(i).getRandomNum();
    }

    private int getGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표를 기준으로 구분)");
        String line = scanner.nextLine();
        return line.split(",");
    }

    private CarStorage inputCars(String[] split) {
        for (int i = 0; i < split.length; i++) {
            Car car = new Car(split[i]);
            cars.add(car);
        }
        return new CarStorage(cars);
    }
}
