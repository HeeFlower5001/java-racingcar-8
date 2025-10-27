package racingcar.domain;

public class Car {
    private static final int NAME_REQUIREMENT = 5;
    private static final int MOVE_REQUIREMENT = 4;

    private final String name;
    private int position = 0;
    private final NumberGenerator numberGenerator;

    public Car(String name) {
        this(name, new NumberGeneratorImpl());
    }

    public Car(String name, NumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (name.length() > NAME_REQUIREMENT) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomValue = numberGenerator.generate();

        if (randomValue >= MOVE_REQUIREMENT) {
            position++;
        }
    }
}