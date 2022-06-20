package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private static final Pattern PATTERN = Pattern.compile("//(.*)\n(.*)");
    private static final int LIMIT = -1;
    private final Numbers numbers;

    public Calculator(final String expression) {
        Delimiter delimiter = new Delimiter();
        String numbersExpression = expression;

        Matcher matcher = PATTERN.matcher(expression);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiter = new Delimiter(customDelimiter);
            numbersExpression = matcher.group(2);
        }

        String[] splitExpression = numbersExpression.split(delimiter.getDelimiter(), LIMIT);

        List<Number> numberList = Arrays.stream(splitExpression)
            .map(Number::new).collect(Collectors.toList());

        this.numbers = new Numbers(numberList);
    }

    public int getResult() {
        return numbers.getResult();
    }

    public void printResult() {
        System.out.println("result is " + numbers.getResult());
    }
}
