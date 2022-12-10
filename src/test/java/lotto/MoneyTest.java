package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
public class MoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"90", "9200", "ab123"})
    void exceptionTest(String string){
        assertThatThrownBy(()->{new Money(string);})
                .isInstanceOf(IllegalArgumentException.class);
    }
}
