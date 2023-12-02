package racingcar.domain;

import racingcar.dto.TrialNumberDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        List<String> carNames = inputView.getCarNamesFromUser();
        Cars cars = new Cars(carNames);
        proceed(inputView.getTrialNumber(), cars);
        printWinner(cars);
    }

    private void proceed(TrialNumberDTO trialNumber, Cars cars) {
        outputView.printFirstShownResultText();
        for (int trial = 0; trial < trialNumber.getTrialNumber(); trial++) {
            List<CarResult> carResults = cars.playTurn();
            outputView.printTurnResult(carResults);
        }
    }

    private void printWinner(Cars cars) {
        Winners winners = cars.getWinners();
        outputView.printWinnersName(winners.getWinnersName());
    }
}
