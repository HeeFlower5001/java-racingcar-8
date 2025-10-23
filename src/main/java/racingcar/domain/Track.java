package racingcar.domain;

import java.util.List;

public class Track {
    private List<Car> carList;
    private final int totalRound;
    private int currentRound = 0;

    public Track(List<Car> carList, int totalRound) {
        this.carList = List.copyOf(carList);
        this.totalRound = totalRound;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void progress() {
        for (Car car : carList) {
            car.move();
        }

        currentRound++;
    }

    public boolean isFinished() {
        return currentRound >= totalRound;
    }
}