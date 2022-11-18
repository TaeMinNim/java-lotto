package lotto;

import lotto.Model.Cash;
import lotto.Model.MyLotto;
import lotto.Model.WinningLotto;

public class Singleton {
    private static Singleton instance = new Singleton();

    public Cash cash;
    public MyLotto myLotto;
    public WinningLotto winningLotto;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
