package racingcar.domain;

import racingcar.dto.TrialNumberDTO;

import java.util.ArrayList;
import java.util.List;

public class TrialNumber {
    private final int trialNumber;

    public TrialNumber(TrialNumberDTO trialNumberDTO) {
        this.trialNumber = trialNumberDTO.getTrialNumber();
    }

    public List<CarResult> playTurnAsMuchAsTrialNumber(Cars cars) {
        List<CarResult> carResults = new ArrayList<>();
        for (int trial = 0; trial < trialNumber; trial++) {
            carResults.add(cars.playTurn());
        }
        return carResults;
    }
}
