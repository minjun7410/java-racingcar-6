package racingcar.domain;

public class CarResult {
    private final String carName;
    private final int movingDistance;

    public CarResult(String carName, int movingDistance) {
        this.carName = carName;
        this.movingDistance = movingDistance;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovingDistance() {
        return movingDistance;
    }
}
