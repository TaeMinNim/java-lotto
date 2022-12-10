package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
    private int bonus = 7;
    @ParameterizedTest
    @MethodSource("generateData")
    void countMatchTest(List<Integer> numbers, int match){
        Lotto lotto = new Lotto(numbers);
        int actual = winningLotto.countMatch(lotto);
        assertThat(actual).isEqualTo(match);
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(List.of(6,5,4,3,2,1), 6),
                Arguments.of(List.of(7,6,5,4,3,2), 5),
                Arguments.of(List.of(8,7,6,5,4,3), 4),
                Arguments.of(List.of(9,8,7,6,5,4), 3),
                Arguments.of(List.of(10,9,8,7,6,5), 2),
                Arguments.of(List.of(11,10,9,8,7,6), 1),
                Arguments.of(List.of(12,11,10,9,8,7), 0)
        );
    }
}
