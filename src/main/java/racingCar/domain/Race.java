package racingCar.domain;

public class Race {

    private final int MIN_VALUE_BY_CAR = 1;
    private final static String IS_NOT_DUAL_CAR_COUNT_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";
    private final static String IS_NOT_DUAL_ROUND_COUNT_ERROR_MESSAGE = "라운드는 1라운드 이상이어야 합니다.";

    public Race(int carCount, int roundCount) {
        validateInput(carCount, roundCount);
    }

    private void validateInput(int carCount, int roundCount) {
        if(isCarCountOverZero(carCount)) {
            throw new IllegalArgumentException(IS_NOT_DUAL_CAR_COUNT_ERROR_MESSAGE);
        }
        if(isRoundCountOverZero(roundCount)) {
            throw new IllegalArgumentException(IS_NOT_DUAL_ROUND_COUNT_ERROR_MESSAGE);
        }
    }

    private boolean isCarCountOverZero(int carCount) {
        return carCount < MIN_VALUE_BY_CAR;
    }

    private boolean isRoundCountOverZero(int roundCount) {
        return roundCount < MIN_VALUE_BY_CAR;
    }

}
