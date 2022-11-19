package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RankTest {
    @ParameterizedTest(name="[{index}] {0}")
    @MethodSource("matchAndRank")
    @DisplayName("getMyRank 메소드 테스트")
    void getRankTest(Rank rank, int match, boolean bonus) {
        Rank actual = Rank.getMyRank(match, bonus);
        assertThat(actual).isEqualTo(rank);
    }

    static Stream<Arguments> matchAndRank() {
        return Stream.of(
                arguments(Rank.FIRST, 6, false),
                arguments(Rank.SECOND, 5, true),
                arguments(Rank.THIRD, 5, false),
                arguments(Rank.FOURTH, 4, false),
                arguments(Rank.FIFTH, 3, false),
                arguments(Rank.LAST, 2, true)
        );
    }
}

