package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputImpl implements Input {
    public String readLine() {
        return Console.readLine();
    }
}