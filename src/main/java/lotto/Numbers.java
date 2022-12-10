package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Numbers {
    private List<Integer> numbers;
    public Numbers(String string) {
        numbers = new ArrayList<>();
        try {
            String[] strings = string.split(",");
            for (int i = 0; i < strings.length; i++) {
                numbers.add(Integer.parseInt(strings[i]));
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 값을 입력하세요.");
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
