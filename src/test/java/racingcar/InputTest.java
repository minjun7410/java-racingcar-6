package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.dto.TrialNumberDTO;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    @Test
    void 올바른_시도횟수_입력_테스트() {
        assertThatNoException().isThrownBy(() -> new TrialNumberDTO(2));
    }

    @Test
    void 올바르지_않은_시도횟수_입력_테스트() {
        assertThatThrownBy(() -> new TrialNumberDTO(-2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_자동차이름_입력_테스트() {
        assertThatNoException().isThrownBy(() -> new Cars(List.of("song, jone , jason")));
    }

    @Test
    void 중복된_자동차이름_예외처리_테스트() {
        assertThatThrownBy(() -> new Cars(List.of("mj", "mj"))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_입력값_공백_예외처리_테스트() {
        assertThatThrownBy(() -> new Cars(List.of("song, , jason"))).isInstanceOf(IllegalArgumentException.class);
    }

}
