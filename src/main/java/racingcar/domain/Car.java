package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int START_LOCATION=0;
    private final String name;
    private int location;

    public Car(String name) throws RuntimeException {
        if(name.length()>5){
            throw new RuntimeException("자동차 이름은 5글자 이내여야 합니다.");
        }
        this.name = name;
        this.location=START_LOCATION;
    }

    public int randomNumGenerator(){
        Random random = new Random();
        return random.nextInt(9)+1;
    }

    public void forward(){
        int randomNum = randomNumGenerator();
        if(randomNum>4){
            this.location++;
        }
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }
}
