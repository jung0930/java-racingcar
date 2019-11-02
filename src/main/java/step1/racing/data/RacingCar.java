package step1.racing.data;

import java.util.stream.IntStream;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 1;
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position > 0 ? position : 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isGreaterThan(int position) {
        return this.position >= position;
    }

    public void moveForward() {
        position++;
    }

    public String printStatus(String flag) {
        String status = IntStream.range(0, position)
                                 .mapToObj(pos -> flag)
                                 .reduce(String::concat).get();

        return name + " : " + status;
    }
}