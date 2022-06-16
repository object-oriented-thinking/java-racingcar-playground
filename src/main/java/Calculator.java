import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private int sum = 0;
    private String[] split;
    Validation validation = new Validation();

    public int add(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(input);
        if (matcher.find()) {
            split = matcher.group(2).split(matcher.group(1));
            validNumber(validation);
            return getSum(sum, split);
        }
        split = input.split("[,;]");
        validNumber(validation);
        return getSum(sum, split);
    }

    private void validNumber(Validation validation) {
        for (String s : split) {
            validation.startValidation(s);
        }
    }

    private int getSum(int sum, String[] split) {
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}