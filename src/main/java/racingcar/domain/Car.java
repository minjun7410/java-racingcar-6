package racingcar.domain;

public class Car {
    private String carName;
    private int movingDistance;

    public Car(String carName) {
        validateCarNameLengthExceed(carName);
        this.carName = carName;
        this.movingDistance = 0;
    }
    private void validateCarNameLengthExceed(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 넘어갈 수 없습니다.");
        }
    }
}
