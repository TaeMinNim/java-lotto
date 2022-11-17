package lotto.Controller;

import lotto.*;
import lotto.Model.Lotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.HashMap;

public class ResultController {
    private HashMap<Rank, Integer> point;
    private double profit;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Singleton storage = Singleton.getInstance();

    public ResultController() {
        point = new HashMap<Rank, Integer>();
        point.put(Rank.FIRST, 0);
        point.put(Rank.SECOND, 0);
        point.put(Rank.THIRD, 0);
        point.put(Rank.FOURTH, 0);
        point.put(Rank.FIFTH, 0);
        point.put(Rank.LAST, 0);
    }

    public void calculateWinning() {
        int total = 0;
        for (Lotto myLotto : storage.myLotto) {
            int match = storage.winningLotto.countMatch(myLotto);
            boolean hasBonus = storage.winningLotto.containBonus(myLotto);
            Rank rank = Rank.getMyRank(match, hasBonus);
            total += rank.getPrize();
            int p = point.get(rank);
            point.replace(rank, p + 1);
        }

        profit = storage.cash.calculateProfit(total);
    }

    public void printResult() {
        outputView.printResult(point, profit);
    }
}
