package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.strategy.MoveStrategy;
import racingCar.domain.strategy.RacingMoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RoundTest {

    List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
    }

    @DisplayName("자동차 대수가 0대 이하일 경우 IllegalArgumentException throw")
    @Test
    void testInputNotDualNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Round(cars);
        }).withMessageMatching("자동차 대수는 1대 이상이어야 합니다.");
    }

    @DisplayName("자동차 대수가 1대 이상일 경우 객체생성")
    @Test
    void testInputDualNumber() {
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        assertThat(new Round(cars)).isInstanceOf(Round.class);
    }

    @DisplayName("자동차 이동 후 객체생성")
    @Test
    void testStartRound() {
        MoveStrategy moveStrategy = new RacingMoveStrategy();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        assertThat(new Round(cars).startRound(moveStrategy)).isInstanceOf(Round.class);
    }


}
