package lotto;

import lotto.Model.CalculatorModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private CalculatorModel calculator;

    @DisplayName("givPrize 메소드 테스트")
    @Nested
    class compareTest {
        @BeforeEach
        void setup() {
            calculator = new CalculatorModel();
        }

        @DisplayName("1등")
        @Test
        void case1() {
            int matchNumber = 6;
            boolean bonus = false;

            Rank actual = calculator.getRank(matchNumber, bonus);
            Rank result = Rank.FIRST;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("2등")
        @Test
        void case2() {
            int matchNumber = 5;
            boolean bonus = true;

            Rank actual = calculator.getRank(matchNumber, bonus);
            Rank result = Rank.SECOND;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("3등")
        @Test
        void case3() {
            int matchNumber = 5;
            boolean bonus = false;

            Rank actual = calculator.getRank(matchNumber, bonus);
            Rank result = Rank.THIRD;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("4등")
        @Test
        void case4() {
            int matchNumber = 4;
            boolean bonus = false;

            Rank actual = calculator.getRank(matchNumber, bonus);
            Rank result = Rank.FOURTH;

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("5등")
        @Test
        void case5() {
            int matchNumber = 3;
            boolean bonus = false;

            Rank actual = calculator.getRank(matchNumber, bonus);
            Rank result = Rank.FIFTH;

            assertThat(actual).isEqualTo(result);
        }
    }

    @DisplayName("calculatorProfit 메소드 테스트")
    @Nested
    class calculatorProfitTest {
        @BeforeEach
        void setup() {
            calculator = new CalculatorModel();
        }

        @Test
        void case1() {
            int totalPrize = 5000;
            int investmentCash = 8000;

            double actual = calculator.getProfit(totalPrize, investmentCash);
            double result = 62.5;
            assertThat(actual).isEqualTo(result);
        }

        @Test
        void case2() {
            int totalPrize = 10000;
            int investmentCash = 30000;

            double actual = calculator.getProfit(totalPrize, investmentCash);
            double result = 33.3;
            assertThat(actual).isEqualTo(result);
        }
    }

    @DisplayName("countLottoNumber 메소드 테스트")
    @Nested
    class countPublicationLottoTest {
        @BeforeEach
        void setup() {
            calculator = new CalculatorModel();
        }

        @Test
        void case1() {
            Cash cash = new Cash(8000);

            int actual = calculator.countLottoNumber(cash);
            int result = 8;
            assertThat(actual).isEqualTo(result);
        }

        @Test
        void case2() {
            Cash cash = new Cash(14000);

            int actual = calculator.countLottoNumber(cash);
            int result = 14;
            assertThat(actual).isEqualTo(result);
        }
    }
}
