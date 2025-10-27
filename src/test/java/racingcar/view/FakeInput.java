package racingcar.view;

public class FakeInput implements Input {
    private final String input;

    public FakeInput(String input) {
        this.input = input;
    }

    @Override
    public String readLine() {
        return input;
    }
}