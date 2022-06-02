package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private static final int CUSTOM_DELIMITER = 1;
    private static final int NUMBERS_EXPRESSION = 2;
    private static final String START_REGEX = "//";
    private static final String END_REGEX = "\n";
    private static final String OR = "|";
    private static final int LIMIT = -1;
    private final Numbers numbers;

    public Calculator(final String expression) {
        Delimiter delimiter = new Delimiter();
        String numbersExpression = expression;

        if (containsCustomDelimiter(expression)) {
            String[] splitExpression = expression.split(START_REGEX + OR + END_REGEX);
            String customDelimiter = splitExpression[CUSTOM_DELIMITER];
            delimiter = new Delimiter(customDelimiter);
            numbersExpression = splitExpression[NUMBERS_EXPRESSION];
        }

        String[] splitExpression = numbersExpression.split(delimiter.getDelimiter(), LIMIT);

        List<Number> numberList = Arrays.stream(splitExpression)
            .map(Number::new).collect(Collectors.toList());

        this.numbers = new Numbers(numberList);
    }

    private boolean containsCustomDelimiter(String expression) {
        return expression.contains(START_REGEX) && expression.contains(END_REGEX);
    }

    public int getResult() {
        return numbers.getNumbers()
            .stream()
            .reduce(Number::addNumber)
            .orElseThrow(RuntimeException::new)
            .getNumber();
    }

    public void printResult() {
        System.out.println("result is " + getResult());
    }
}
