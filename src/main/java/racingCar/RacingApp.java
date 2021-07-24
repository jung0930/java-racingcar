package racingCar;

import racingCar.domain.Car;
import racingCar.domain.Race;
import racingCar.domain.strategy.MoveStrategy;
import racingCar.domain.strategy.RacingMoveStrategy;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.List;

public class RacingApp {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public static void main(String[] args) {
        RacingApp app = new RacingApp();
        app.Race();
    }

    private void Race() {
        int carCount = this.inputView.EnterCarNumber();
        int moveCount = this.inputView.EnterMoveCount();

        MoveStrategy moveStrategy = new RacingMoveStrategy();
        Race race = new Race(carCount);

        start(race, moveStrategy, carCount, moveCount);
    }

    private void start(Race race, MoveStrategy moveStrategy, int moveCount, int carCount) {
        this.resultView.printExecutionResultMessage();

        for(int i = 0; i < moveCount; i++) {
            race = race.moveCar(moveStrategy);
            outputCarDistance(race.getCars(), carCount);
        }
    }

    private void outputCarDistance(List<Car> cars, int carCount) {
        for(int i = 0; i < carCount; i++) {
            this.resultView.printCarDistance(cars.get(i).getCarDistance());
        }
        this.resultView.printEnter();
    }

}
