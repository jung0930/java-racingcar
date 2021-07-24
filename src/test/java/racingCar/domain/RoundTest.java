package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RoundTest {

    @DisplayName("자동차 대수가 0대 이하일 경우 IllegalArgumentException throw")
    @Test
    void testInputNotDualNumber() {
        List<Car> cars = new ArrayList<>();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Round(cars);
        }).withMessageMatching("자동차 대수는 1대 이상이어야 합니다.");
    }

    @DisplayName("자동차 대수가 1대 이상일 경우 객체생성")
    @Test
    void testInputDualNumber() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        assertThat(new Round(cars)).isInstanceOf(Round.class);
    }


}
