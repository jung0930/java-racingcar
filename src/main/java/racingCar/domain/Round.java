package racingCar.domain;

import racingCar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private final List<Car> cars;
    private final int MIN_VALUE_BY_CAR = 1;
    private final static String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";

    public Round(List<Car> cars) {
        validateCarsSize(cars);
        this.cars = cars;
    }

    private void validateCarsSize(List<Car> cars) {
        if(isCarsSizeOverZero(cars)) {
            throw new IllegalArgumentException(IS_NOT_DUAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean isCarsSizeOverZero(List<Car> cars) {
        return cars.size() < MIN_VALUE_BY_CAR;
    }

    public Round startRound(MoveStrategy moveStrategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : this.cars) {
            movedCars.add(car.move(moveStrategy.isMoveable()));
        }
        return new Round(movedCars);
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
