package racing.domain;

public class Car {

    private final String name;
    private final StringBuilder location;

    public Car(String name, StringBuilder location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public StringBuilder getLocation() {
        return location;
    }
}
