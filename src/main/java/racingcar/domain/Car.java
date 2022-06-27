package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int MAX_BOUND=10;
    private final Name name;
    private final Location location;

    public Car(Name name) {
        this.name = name;
        this.location=new Location();
    }

    protected int randomNumGenerator(){
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public void forward(){
        int randomNum = randomNumGenerator();
        if(randomNum>=4){
            this.location.forward();
        }
    }

    public Location getLocation() {
        return this.location;
    }

    public Name getName() {
        return this.name;
    }
}
