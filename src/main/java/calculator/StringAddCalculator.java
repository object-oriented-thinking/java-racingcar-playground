package calculator;

import calculator.domain.Numbers;
import calculator.service.AddService;
import calculator.service.SplitService;

public class StringAddCalculator {
    static SplitService splitService = new SplitService();
    static AddService addService = new AddService();

    public static boolean isBlank(String input){
        return input == null || input.isEmpty();
    }

    public static int splitAndSum(String input) throws RuntimeException{
        if(isBlank(input)){
            return 0;
        }

        Numbers numbers = splitService.splitString(input);
        return addService.addAll(numbers);
    }
}