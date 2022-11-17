package lotto;

import java.util.List;

public class WinningLotto extends Lotto{
    private int bonus;

    public WinningLotto(List<Integer> numbers, int bonus){
        super(numbers);
        isValidData(bonus);
        this.bonus = bonus;
    }

    private void isValidData(int bonus) {
        if (!(bonus >= 1 && bonus <= 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (super.contain(bonus)) {
            throw new IllegalArgumentException("중복되는 번호를 보너스 번호로 선택할 수 없습니다.");
        }
    }

    public boolean containBonus(Lotto lotto) {
        return lotto.contain(bonus);
    }
}
