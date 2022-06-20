package racingcar.domain;

import java.util.Objects;

public class Location{
    private int location;

    public Location() {
        this.location=0;
    }
    public Location(int location) {
        this.location = location;
    }

    public void forward(){
        this.location++;
    }

    public String makeBar(){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<location;i++){
            result.append("-");
        }
        return result.toString();
    }

    public boolean isGreaterThan(Location o) {
        return this.location > o.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
