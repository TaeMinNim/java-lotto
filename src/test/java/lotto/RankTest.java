package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("getMyRank 메소드 테스트")
    @Nested
    class getMyRankTest {
        @DisplayName("1등")
        @Test
        void case1() {
            int match = 6;
            boolean bonus = false;

            Rank actual = Rank.getMyRank(match, bonus);
            Rank result = Rank.FIRST;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("2등")
        @Test
        void case2() {
            int match = 5;
            boolean bonus = true;

            Rank actual = Rank.getMyRank(match, bonus);
            Rank result = Rank.SECOND;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("3등")
        @Test
        void case3() {
            int match = 5;
            boolean bonus = false;

            Rank actual = Rank.getMyRank(match, bonus);
            Rank result = Rank.THIRD;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("4등")
        @Test
        void case4() {
            int match = 4;
            boolean bonus = false;

            Rank actual = Rank.getMyRank(match, bonus);
            Rank result = Rank.FOURTH;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("5등")
        @Test
        void case5() {
            int match = 3;
            boolean bonus = false;

            Rank actual = Rank.getMyRank(match, bonus);
            Rank result = Rank.FIFTH;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("꽝")
        @Test
        void case6() {
            int match = 2;
            boolean bonus = true;

            Rank actual = Rank.getMyRank(match, bonus);
            Rank result = Rank.LAST;

            assertThat(actual).isEqualTo(result);
        }
    }
}
