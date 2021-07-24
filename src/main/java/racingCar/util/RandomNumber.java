package racingCar.util;

import java.util.Random;

public class RandomNumber {
    private static final int BOUND_BY_RACING_CAR = 10;
    private static Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(BOUND_BY_RACING_CAR);
    }

}
