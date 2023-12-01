package racingcar.domain;

import racingcar.dto.WinnerNameDTO;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winners {
    private static final int FIRST_WINNER_INDEX = 0;

    private final List<Car> winners;

    public Winners(List<Car> cars) {
        winners = new ArrayList<>();
        decide(cars);
    }

    public List<WinnerNameDTO> getWinnersName() {
        List<WinnerNameDTO> winnerNameList = new ArrayList<>();
        for (Car winner : winners) {
            winnerNameList.add(new WinnerNameDTO(winner.getCarName()));
        }
        return winnerNameList;
    }

    private void decide(List<Car> cars) {
        cars.sort(Comparator.reverseOrder());

        int carIndex = FIRST_WINNER_INDEX;
        Car firstWinner = cars.get(carIndex);
        while (carIndex < cars.size() && IsNextCarWinner(cars.get(carIndex), firstWinner)) {
            winners.add(cars.get(carIndex));
            carIndex++;
        }
    }

    private boolean IsNextCarWinner(Car car, Car winner) {
        return (car.compareTo(winner) == 0);
    }

    public int getWinnersSize() {
        return winners.size();
    }
}
