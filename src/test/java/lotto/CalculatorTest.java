package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CashTest {
    @DisplayName("calculateProfit 메소드 테스트")
    @Nested
    class calculateProfitTest {
        @DisplayName("나누어 떨어지는 경우")
        @Test
        void case1() {
            int total = 5000;
            Cash cash = new Cash(8000);

            double actual = cash.calculateProfit(total);
            double result = 62.5;
            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("버리는 경우")
        @Test
        void case2() {
            int total = 10000;
            Cash cash = new Cash(30000);

            double actual = cash.calculateProfit(total);
            double result = 33.3;
            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("올리는 경우")
        @Test
        void case3() {
            int total = 5000;
            Cash cash = new Cash(9000);

            double actual = cash.calculateProfit(total);
            double result = 55.6;
            assertThat(actual).isEqualTo(result);
        }
    }

    @DisplayName("calculateLottoNumber 메소드 테스트")
    @Nested
    class countLottoNumberTest {
        @DisplayName("8000원")
        @Test
        void case1() {
            Cash cash = new Cash(8000);

            int actual = cash.calculateLottoCount();
            int result = 8;
            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("14000원")
        @Test
        void case2() {
            Cash cash = new Cash(14000);

            int actual = cash.calculateLottoCount();
            int result = 14;
            assertThat(actual).isEqualTo(result);
        }
    }
}
