package racingcar.domain;

import java.util.Objects;

public class Name {
    private final String name;
    private static final int MAX_LENGTH = 5;

    public Name(String name) throws IllegalArgumentException {
        if (name==null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (name.length() >= MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이내여야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
