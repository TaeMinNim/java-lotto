package lotto;

import lotto.Model.Cash;
import lotto.Model.Lotto;
import lotto.Model.WinningLotto;

import java.util.List;

public class Singleton {
    private static Singleton instance = new Singleton();

    public Cash cash;
    public List<Lotto> myLotto;
    public WinningLotto winningLotto;

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
