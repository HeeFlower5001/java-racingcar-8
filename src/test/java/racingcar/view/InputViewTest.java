package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @Test
    void 쉼표로_이름을_정확히_분리한다() {
        InputView inputView = new InputView(new FakeInput("pobi,woni,jun"));

        List<String> nameList = List.of("pobi", "woni", "jun");
        assertThat(inputView.inputCarNames()).isEqualTo(nameList);
    }

    @Test
    void 라운드가_숫자가_아니면_예외() {
        InputView inputView = new InputView(new FakeInput("a"));

        assertThrows(IllegalArgumentException.class, inputView::inputTotalRound);
    }

    @Test
    void 라운드가_0이하면_예외() {
        InputView inputView = new InputView(new FakeInput("0"));

        assertThrows(IllegalArgumentException.class, inputView::inputTotalRound);
    }

    @Test
    void 라운드가_타당한_경우() {
        InputView inputView = new InputView(new FakeInput("4"));

        assertThat(inputView.inputTotalRound()).isEqualTo(4);
    }
}