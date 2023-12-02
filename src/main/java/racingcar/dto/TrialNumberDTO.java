package racingcar.dto;

public class TrialNumberDTO {
    private static final String TRIALNUMBER_RANGE_ERROR = "올바른 시도 횟수 입력이 아닙니다.";
    private final int trialNumber;

    public TrialNumberDTO(int trialNumber) {
        validateTrialNumberRange(trialNumber);
        this.trialNumber = trialNumber;
    }

    public int getTrialNumber() {
        return trialNumber;
    }

    private void validateTrialNumberRange(int trialNumber) {
        if (trialNumber >= 0) return;
        throw new IllegalArgumentException(TRIALNUMBER_RANGE_ERROR);
    }
}
