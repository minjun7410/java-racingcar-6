package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String DUPLICATED_CARNAME_ERROR = "차 이름이 중복되었습니다.";
    private static final String MAXIMUM_CAR_NUMBER_ERROR = "차의 개수는 %d 을 넘어갈 수 없습니다.";
    private static final int CAR_MAXIMUM_NUMBER = 10;
    private final List<Car> cars;

    public Cars(List<String> carNameList) {
        cars = new ArrayList<>();
        addCarInCars(carNameList);
    }

    public List<CarResult> playTurn() {
        List<CarResult> carResults = new ArrayList<>();
        for (Car car : cars) {
            car.moveRandomly();
            carResults.add(car.getMoveResult());
        }
        return carResults;
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    private void addCarInCars(List<String> carNameList) {
        for (String carName : carNameList) {
            Car newCar = new Car(carName);
            validateDuplicatedCarName(newCar);
            cars.add(newCar);
            validateCarsMaximumNumber();
        }
    }

    private void validateDuplicatedCarName(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(DUPLICATED_CARNAME_ERROR);
        }
    }

    private void validateCarsMaximumNumber() {
        if (cars.size() >= CAR_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format(MAXIMUM_CAR_NUMBER_ERROR, CAR_MAXIMUM_NUMBER));
        }
    }
}
