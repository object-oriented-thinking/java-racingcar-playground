package racingcar.entity;

import java.util.Objects;

public class Distance {
    private final int distance;

    public Distance() {
        this.distance = 0;
    }

    public Distance(int distance) {

        if (distance < 0) {
            throw new IllegalArgumentException("음수가 될 수 없습니다.");
        }

        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return getDistance() == distance1.getDistance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDistance());
    }
}
