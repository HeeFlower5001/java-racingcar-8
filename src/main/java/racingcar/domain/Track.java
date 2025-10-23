package racingcar.domain;

import java.util.List;

public class Track {
    private final List<Car> carList;
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

    public List<Car> getFirstCars() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<Car> list = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

        return list;
    }
}