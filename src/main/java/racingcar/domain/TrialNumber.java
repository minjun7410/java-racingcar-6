package racingcar.domain;

import racingcar.dto.TrialNumberDTO;
import racingcar.view.OutputView;

public class TrialNumber {
    private final int trialNumber;

    public TrialNumber(TrialNumberDTO trialNumberDTO) {
        this.trialNumber = trialNumberDTO.getTrialNumber();
    }

    public void playTurnAsMuchAsTrialNumber(Cars cars) {
        OutputView.printFirstShownResultText();
        for (int trial = 0; trial < trialNumber; trial++) {
            cars.playTurn();
        }
    }


}
