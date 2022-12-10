package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

public class RankTest {
    @ParameterizedTest
    @MethodSource("generateData")
    void checkRankTest(int match, boolean bonus, Rank rank){
        Rank actual = Rank.checkRank(match, bonus);
        assertThat(actual).isEqualTo(rank);
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FORTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, true, Rank.LAST),
                Arguments.of(1, false, Rank.LAST),
                Arguments.of(0, false, Rank.LAST)
        );
    }
}
