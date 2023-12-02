package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.TrialNumberDTO;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String TRIAL_NUMBER_INPUT_TEXT = "시도할 회수는 몇회인가요?\n";
    private static final String CAR_NAME_INPUT_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String TRIAL_NUMBER_ERROR = "시도 횟수는 정수를 입력해주세요.";

    public TrialNumberDTO getTrialNumber() {
        System.out.print(TRIAL_NUMBER_INPUT_TEXT);
        int trialNumber = convertToInteger(Console.readLine().trim());
        return new TrialNumberDTO(trialNumber);
    }

    public List<String> getCarNamesFromUser() {
        System.out.print(CAR_NAME_INPUT_TEXT);
        return splitInputByComma(Console.readLine());
    }

    private List<String> splitInputByComma(String input) {
        String[] splitInputArray = input.split(",");
        return trimInputOneByOne(splitInputArray);
    }

    private List<String> trimInputOneByOne(String[] inputList) {
        List<String> trimInputList = new ArrayList<>();
        for (String input : inputList) {
            trimInputList.add(input.trim());
        }
        return trimInputList;
    }

    private int convertToInteger(String trialNumberInput) {
        validateNotInteger(trialNumberInput);
        return Integer.parseInt(trialNumberInput);
    }

    private void validateNotInteger(String trialNumber) {
        if (trialNumber.matches("\\d*")) {
            return;
        }
        throw new IllegalArgumentException(TRIAL_NUMBER_ERROR);
    }
}
