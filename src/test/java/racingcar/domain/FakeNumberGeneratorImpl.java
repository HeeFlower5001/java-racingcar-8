package racingcar.domain;

public class FakeNumberGeneratorImpl implements NumberGenerator {
    private final int fixedValue;

    public FakeNumberGeneratorImpl(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate() {
        return fixedValue;
    }
}
