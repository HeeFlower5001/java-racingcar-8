package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackTest {
    @Test
    void progress가_모든_차를_전진시킨다() {
        Car a = new Car("a", new FakeNumberGeneratorImpl(5));
        Car b = new Car("b", new FakeNumberGeneratorImpl(2));
        Track track = new Track(List.of(a, b), 1);

        track.progress();

        assertThat(a.getPosition()).isEqualTo(1);
        assertThat(b.getPosition()).isEqualTo(0);
    }

    @Test
    void 라운드수가_끝나면_isfinished_true() {
        Car a = new Car("a", new FakeNumberGeneratorImpl(5));
        Track track =  new Track(List.of(a), 2);

        assertThat(track.isFinished()).isFalse();
        track.progress();

        assertThat(track.isFinished()).isFalse();
        track.progress();

        assertThat(track.isFinished()).isTrue();
    }

    @Test
    void 우승자가_단독인_경우() {
        Car a = new Car("a", new FakeNumberGeneratorImpl(5));
        Car b = new Car("b", new FakeNumberGeneratorImpl(2));
        Track track = new Track(List.of(a, b), 1);

        track.progress();

        assertThat(track.getFirstCars())
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("a");
    }

    @Test
    void 우승자가_공동인_경우() {
        Car a = new Car("a", new FakeNumberGeneratorImpl(5));
        Car b = new Car("b", new FakeNumberGeneratorImpl(5));
        Track track = new Track(List.of(a, b), 1);

        track.progress();

        assertThat(track.getFirstCars())
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("a", "b");
    }
}
