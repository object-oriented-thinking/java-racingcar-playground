package calculator;

import calculator.service.AddService;
import calculator.service.SplitService;

public class StringAddCalculator {
    static SplitService splitService = new SplitService();
    static AddService addService = new AddService();

    public static boolean isBlank(String s){
        return s == null || s.isEmpty();
    }

    public static int splitAndSum(String s) throws RuntimeException{
        if(isBlank(s)){
            return 0;
        }

        String[] numbers = splitService.splitString(s);

        if(addService.containsNeg(numbers)){
            throw new RuntimeException("음수가 전달되었습니다");
        }

        return addService.addAll(numbers);
    }
}
