package racingcar.view;

import java.util.List;

public class InputView {
    private final Input input;

    public InputView() {
        this(new InputImpl());
    }

    public InputView(Input input) {
        this.input = input;
    }

    static String[] parseStringToNames(String input) {
        return input.split(",");
    }

    static int validateRound(String input) {
        int totalRound;

        try {
            totalRound = Integer.parseInt(input);

        } catch(NumberFormatException e) {
            // totalRound가 숫자가 아닌경우
            throw new IllegalArgumentException();
        }

        if (totalRound <= 0) {
            throw new IllegalArgumentException();
        }

        return totalRound;
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = input.readLine();

        List<String> nameList = List.of(parseStringToNames(names));

        return nameList;
    }

    public int inputTotalRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String number = input.readLine();

        int round = validateRound(number);

        return round;
    }
}