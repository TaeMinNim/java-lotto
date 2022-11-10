package lotto;

import lotto.domain.Judgment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;


class JudgmentTest {
    private Judgment judgment;
    private List<Integer> winningNumber = List.of(1,2,3,4,5,6);

    @DisplayName("compare 메소드 테스트")
    @Nested
    class compareTest{
        @BeforeEach
        void setup(){
            judgment = new Judgment();
        }

        @DisplayName("0개 매치")
        @Test
        void case1(){
            List<Integer> playerNumber = List.of(7,8,9,10,11,12);
            int result = 0;
            int actual = judgment.compare(winningNumber, playerNumber);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("1개 매치")
        @Test
        void case2(){
            List<Integer> playerNumber = List.of(6,7,8,9,10,11);
            int result = 1;
            int actual = judgment.compare(winningNumber, playerNumber);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("2개 매치")
        @Test
        void case3(){
            List<Integer> playerNumber = List.of(5,6,7,8,9,10);
            int result = 2;
            int actual = judgment.compare(winningNumber, playerNumber);

            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("3개 매치")
        @Test
        void case4(){
            List<Integer> playerNumber = List.of(4,5,6,7,8,9);
            int result = 3;
            int actual = judgment.compare(winningNumber, playerNumber);

            assertThat(actual).isEqualTo(result);
        }
    }

}
