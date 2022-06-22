
public class CarLocation {
    private static final int ADVANCE_RANDOM_NUMBER = 4;
    private final StringBuffer stringLocation = new StringBuffer("-");

    public StringBuffer getCarLocation(int randomNumber) {
        if (randomNumber >= ADVANCE_RANDOM_NUMBER) {
            this.stringLocation.append("-");
        }
        return this.stringLocation;
    }

    public StringBuffer getStringLocation() {
        return this.stringLocation;
    }
}
