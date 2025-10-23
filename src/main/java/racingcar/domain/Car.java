package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int NAME_REQUIREMENT = 5;
    private static final int MOVE_REQUIREMENT = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
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
        int randomValue = Randoms.pickNumberInRange(0, 9);

        if (randomValue >= MOVE_REQUIREMENT) {
            position++;
        }
    }
}