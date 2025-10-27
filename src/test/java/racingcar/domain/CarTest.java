package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void 이름이_null이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 이름이_공백이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Car(" "));
    }

    @Test
    void 이름이_6글자를_넘으면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Car("6글자이상은"));
    }

    @Test
    void 이름이_타당한_경우() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 랜덤값이_4이상이면_이동() {
        FakeNumberGeneratorImpl fakeNumberGenerator = new FakeNumberGeneratorImpl(4);
        Car car = new Car("pobi", fakeNumberGenerator);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_3이하면_멈춤() {
        FakeNumberGeneratorImpl fakeNumberGenerator = new FakeNumberGeneratorImpl(3);
        Car car = new Car("pobi", fakeNumberGenerator);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }
}