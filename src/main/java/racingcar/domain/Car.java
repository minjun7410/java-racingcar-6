package racingcar.domain;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private int movingDistance = 0;

    public Car(String carName) {
        this.carName = new CarName(carName);
    }

    public String getCarName() {
        return carName.toString();
    }

    public CarResult getMoveResult() {
        return new CarResult(carName.toString(), movingDistance);
    }

    public int moveRandomly() {
        if (Dice.isSuccess()) {
            movingDistance++;
        }
        return movingDistance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Car.class) {
            CarName opponentCarName = ((Car) obj).carName;
            return opponentCarName.equals(this.carName);
        }
        return false;
    }

    @Override
    public int compareTo(Car o) {
        return this.movingDistance - o.movingDistance;
    }
}
