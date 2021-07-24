package racingCar.domain;

import java.util.List;

public class Race {

    private final int MIN_VALUE_BY_CAR = 1;
    private final static String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";

    public Race(int carCount, int roundCount) {
        validateInput(carCount);
    }

    private void validateInput(int carCount) {
        if(isCarsSizeOverZero(carCount)) {
            throw new IllegalArgumentException(IS_NOT_DUAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean isCarsSizeOverZero(int carCount) {
        return carCount < MIN_VALUE_BY_CAR;
    }

}
