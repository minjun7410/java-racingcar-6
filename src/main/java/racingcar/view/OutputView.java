package racingcar.view;

import racingcar.domain.CarResult;

import java.util.List;

public class OutputView {
    private static final String FIRST_SHOWN_RESULT_TEXT = "실행 결과\n";
    private static final String FIRST_SHOWN_WINNER_TEXT = "최종 우승자 : ";

    public void printWinners(List<String> winners) {
        printFirstShownWinnerText();
        System.out.println(String.join(", ", winners));
    }

    public void printFirstShownWinnerText() {
        System.out.print(FIRST_SHOWN_WINNER_TEXT);
    }

    public void printTurnResult(List<CarResult> results) {
        for (CarResult result : results) {
            printCarMovingDistance(result);
        }
    }

    private void printCarMovingDistance(CarResult result) {
        System.out.print(result.getCarName() + " : ");
        for (int moved = 0; moved < result.getMovingDistance(); moved++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printFirstShownResultText() {
        System.out.print(FIRST_SHOWN_RESULT_TEXT);
    }
}
