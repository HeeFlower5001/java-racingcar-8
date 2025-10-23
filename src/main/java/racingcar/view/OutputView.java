package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Track;

import java.util.List;

public class OutputView {
    private OutputView() {

    }

    public static void showPerRoundResult(Track track) {
        List<Car> carList = track.getCarList();

        for (Car car : carList) {
            showCarResult(car);
        }

        System.out.println();
    }

    public static void showFinalResult(Track track) {
        List<Car> firstCars = track.getFirstCars();

        String winners = firstCars.stream()
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");

        System.out.println("최종 우승자 : " + winners);
    }

    private static void showCarResult(Car car) {
        System.out.printf("%s : ", car.getName());
        printPosition(car.getPosition());

        System.out.println();
    }

    private static void printPosition(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("-");
        }
    }
}