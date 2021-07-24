package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RaceTest {

    @DisplayName("자동차 대수, 경기수가 1 이상일때 객체생성")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "5:3", "10:2"}, delimiter = ':')
    void testInput(int carCount, int roundCount) {
        assertThat(new Race(carCount,roundCount)).isInstanceOf(Race.class);
    }

    @DisplayName("자동차 대수가 1대 이하일때 IllegalArgumentException throw")
    @ParameterizedTest
    @CsvSource(value = {"0:5", "-10:10", "-20:15"}, delimiter = ':')
    void testInputNegativeCarsCount(int carCount, int roundCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Race(carCount, roundCount);
        }).withMessageMatching("자동차 대수는 1대 이상이어야 합니다.");
    }

    /*
    @DisplayName("자동차 대수가 1대 이하일때 IllegalArgumentException throw")
    @ParameterizedTest
    @CsvSource(value = {"0:5", "-10:10", "-20:15"}, delimiter = ':')
    void testInputNegativeCarsCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            race = new Race(input);
        }).withMessageMatching("자동차 대수는 1대 이상이어야 합니다.");
    }

    @DisplayName("자동차 대수가 1대 이상일 경우 객체 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void inputDualNumberTest(int input) {
        assertThat(new Race(input)).isInstanceOf(Race.class);
    }

    @DisplayName("입력값과 생성된 리스트의 길이가 같은지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void carsLengthTest(int input) {
        assertThat(new Race(input).getCars().size()).isEqualTo(input);
    }
    */
}