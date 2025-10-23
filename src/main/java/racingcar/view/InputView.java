package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private InputView() {

    }

    private static String[] parseStringToNames(String input) {
        return input.split(",");
    }

    private static int validateRound(String input) {
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

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> names = List.of(parseStringToNames(input));

        return names;
    }

    public static int inputTotalRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        int round = validateRound(input);

        return round;
    }
}