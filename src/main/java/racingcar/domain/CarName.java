package racingcar.domain;

import racingcar.view.OutputView;

import java.util.List;

public class CarName {
    private static final String CARNAME_SIZE_ERROR = "자동차의 이름은 5자를 넘어갈 수 없습니다.";
    private static final String CARNAME_BRANK_ERROR = "자동차의 이름은 공백이 될 수 없습니다.";
    private final String carName;

    public CarName(String carName) {
        validateCarNameLengthExceed(carName);
        validateCarNameLengthZero(carName);
        this.carName = carName;
    }

    private void validateCarNameLengthExceed(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CARNAME_SIZE_ERROR);
        }
    }

    private void validateCarNameLengthZero(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(CARNAME_BRANK_ERROR);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == CarName.class) {
            String opponentCarNameStr = ((CarName) obj).carName;
            return opponentCarNameStr.equals(this.carName);
        }
        return false;
    }

    @Override
    public String toString() {
        return carName;
    }
}
