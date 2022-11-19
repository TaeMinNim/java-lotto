package lotto;

import lotto.Model.Cash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CashTest {
    @DisplayName("데이터 유효 테스트")
    @Nested
    class isValidDataTest {
        @DisplayName("유효하지 않은 경우")
        @ParameterizedTest(name="[{index}] cash = {0}")
        @ValueSource(ints = {-1000, 2500, 50})
        void notValid(int cash) {
            assertThatThrownBy(() -> {
                new Cash(cash);
            })
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("유효한 경우")
        @ParameterizedTest(name="[{index}] cash = {0}")
        @ValueSource(ints = {1000, 3000, 5000})
        void valid(int cash) {
            assertThat(new Cash(cash))
                    .isInstanceOf(Cash.class);
        }
    }

    @DisplayName("calculateProfit 메소드 테스트")
    @Nested
    class calculateProfitTest {
        @ParameterizedTest(name="[{index}] money={0}/total={1}/result={2}")
        @CsvSource(value = { "8000:5000:62.5", "30000:10000:33.3", "9000:5000:55.6"}, delimiter = ':')
        void divided(int money, int total, double result) {
            Cash cash = new Cash(money);
            double actual = cash.calculateProfit(total);
            assertThat(actual).isEqualTo(result);
        }
    }

    @DisplayName("calculateLottoNumber 메소드 테스트")
    @Nested
    class countLottoNumberTest {
        @ParameterizedTest(name="[{index}] money={0}/result={1}")
        @CsvSource(value={ "8000:8", "14000:14" }, delimiter=':')
        void success(int money, int result) {
            Cash cash = new Cash(money);
            int actual = cash.calculateLottoCount();
            assertThat(actual).isEqualTo(result);
        }
    }
}
