package lotto;

import lotto.Model.CalculatorModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("findRank 메소드 테스트")
    @Nested
    class findRankTest {
        @DisplayName("1등")
        @Test
        void case1() {
            int matchNumber = 6;
            boolean bonus = false;

            Rank actual = Rank.findRank(matchNumber, bonus);
            Rank result = Rank.FIRST;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("2등")
        @Test
        void case2() {
            int matchNumber = 5;
            boolean bonus = true;

            Rank actual = Rank.findRank(matchNumber, bonus);
            Rank result = Rank.SECOND;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("3등")
        @Test
        void case3() {
            int matchNumber = 5;
            boolean bonus = false;

            Rank actual = Rank.findRank(matchNumber, bonus);
            Rank result = Rank.THIRD;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("4등")
        @Test
        void case4() {
            int matchNumber = 4;
            boolean bonus = false;

            Rank actual = Rank.findRank(matchNumber, bonus);
            Rank result = Rank.FOURTH;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("5등")
        @Test
        void case5() {
            int matchNumber = 3;
            boolean bonus = false;

            Rank actual = Rank.findRank(matchNumber, bonus);
            Rank result = Rank.FIFTH;

            assertThat(actual).isEqualTo(result);
        }
    }
}