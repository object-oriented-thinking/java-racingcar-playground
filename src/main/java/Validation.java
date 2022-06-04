public class Validation {

    public int startValidation(String input){
        if (isNegativeNumber(input)) {
            throw new RuntimeException("양수만 입력해주세요");
        }
        return Integer.parseInt(input);
    }

    public boolean isNegativeNumber(String input) {
        return Integer.parseInt(input)<0;
    }
}
