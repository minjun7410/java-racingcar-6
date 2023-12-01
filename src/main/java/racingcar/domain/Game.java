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
        Cars cars = inputView.getCarsFromUser();
        proceed(inputView.getTrialNumber(), cars);
        Winners winners = cars.getWinners();
        winners.print();
    }

    private void proceed(TrialNumberDTO trialNumber, Cars cars) {
        outputView.printFirstShownResultText();
        for (int trial = 0; trial < trialNumber.getTrialNumber(); trial++) {
            List<CarResult> carResults = cars.playTurn();
            outputView.printTurnResult(carResults);
        }
    }


}
