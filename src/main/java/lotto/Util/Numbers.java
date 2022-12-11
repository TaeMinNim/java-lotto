package lotto.Util;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> numbers;
    public Numbers(String string) {
        numbers = trans(string);
    }

    private List<Integer> trans(String string) throws IllegalArgumentException{
        List<Integer> numbers = new ArrayList<>();
        try {
            String[] strings = string.split(",");
            for (int i = 0; i < strings.length; i++) {
                Number number = new Number(strings[i]);
                numbers.add(number.getNumber());
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 값을 입력하세요.");
        }

        return numbers;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
