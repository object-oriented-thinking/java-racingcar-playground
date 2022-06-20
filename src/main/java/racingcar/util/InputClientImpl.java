package racingcar.util;

import java.util.Scanner;

public class InputClientImpl implements InputClient {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String inputName() {
        return SCANNER.nextLine();
    }

    @Override
    public int inputCount() {
        int count = SCANNER.nextInt();
        if (count < 1) {
            throw new IllegalArgumentException();
        }
        return count;
    }
}
