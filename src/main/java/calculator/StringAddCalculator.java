package calculator;

import calculator.domain.Numbers;
import calculator.service.AddService;
import calculator.service.SplitService;

public class StringAddCalculator {
    private static final SplitService splitService = new SplitService();
    private static final AddService addService = new AddService();

    private static boolean isBlank(String input){
        return input == null || input.trim().isEmpty();
    }

    public static int splitAndSum(String input) throws RuntimeException{
        if(isBlank(input)){
            return 0;
        }

        Numbers numbers = splitService.splitString(input);
        return addService.addAll(numbers);
    }
}
