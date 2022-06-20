package racingcar.entity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    private static final String REGEX = "^[a-zA-Z0-9]*$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private final String name;

    public Name(String name) {
        Matcher m = PATTERN.matcher(name);

        if (!m.matches()) {
            throw new IllegalArgumentException("특수문자는 안됩니다.");
        }

        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("길이는 5 이하이어야 합니다.");
        }

        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
