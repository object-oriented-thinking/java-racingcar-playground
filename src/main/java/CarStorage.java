import java.util.Collections;
import java.util.List;

public class CarStorage {

    private final List<Car> cars;

    public CarStorage(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
