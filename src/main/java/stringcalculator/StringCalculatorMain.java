package stringcalculator;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String expression = "//+\n1,2+3,4";
        Calculator calculator = new Calculator(expression);
        calculator.printResult();
    }
}
