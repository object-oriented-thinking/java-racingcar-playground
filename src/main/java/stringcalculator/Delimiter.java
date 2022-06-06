package stringcalculator;

public class Delimiter {
    private static final String OR = "|";
    private static final String EMPTY_DELIMITER = "";
    private static final String DELIMITER = "," + OR + ":";
    private final String delimiter;

    public Delimiter(String customDelimiter) {
        String delimiter = DELIMITER;

        if (!customDelimiter.trim().isEmpty()) {
            delimiter += OR + "\\" + customDelimiter;
        }

        this.delimiter = delimiter;
    }

    public Delimiter() {
        this(EMPTY_DELIMITER);
    }

    public boolean compareTo(String delimiter) {
        if (!this.delimiter.contains(delimiter)) {
            throw new IllegalArgumentException("지정된 기호가 아닙니다.");
        }
        return true;
    }

    public String getDelimiter() {
        return delimiter;
    }

}
