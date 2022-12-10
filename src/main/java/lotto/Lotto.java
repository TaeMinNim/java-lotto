package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatch(Lotto other){
        int count = 0;
        for(int number: other.numbers){
            if(this.numbers.contains(number)){
                count++;
            }
        }

        return count;
    }

    public boolean hasBonus(int bonus){
        return numbers.contains(bonus);
    }
}
