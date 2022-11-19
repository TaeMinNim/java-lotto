package lotto;

import lotto.Model.Lotto;
import lotto.Model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

class WinningLottoTest {
    private WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

    @DisplayName("countMatch 메소드 테스트")
    @Nested
    class countMatch {
        @ParameterizedTest(name="[{index}] {1}개 매치")
        @MethodSource("lotto.WinningLottoTest#generateData")
        void countMatch(List<Integer> numbers, int result) {
            Lotto myLotto = new Lotto(numbers);
            int actual = winningLotto.countMatch(myLotto);
            assertThat(actual).isEqualTo(result);
        }
    }
    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 0),
                Arguments.of(List.of(6, 7, 8, 9, 10, 11), 1),
                Arguments.of(List.of(5, 6, 7, 8, 9, 10), 2),
                Arguments.of(List.of(4, 5, 6, 7, 8, 9), 3),
                Arguments.of(List.of(3, 4, 5, 6, 7, 8), 4),
                Arguments.of(List.of(2, 3, 4, 5, 6, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }
}
