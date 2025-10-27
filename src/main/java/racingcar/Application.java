package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Track;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 입력 받기
        InputView inputView = new InputView();

        final List<String> nameList = inputView.inputCarNames();
        final int totalRound = inputView.inputTotalRound();

        // 2. Car, Track 생성
        List<Car> carList = nameList.stream()
                .map(Car::new)
                .toList();

        Track track = new Track(carList, totalRound);

        // 3. 진행 및 결과 출력
        System.out.println();
        System.out.println("실행 결과");

        while (!track.isFinished()) {
            track.progress();
            OutputView.showPerRoundResult(track);
        }

        OutputView.showFinalResult(track);
    }
}