package lotto.Controller;

import lotto.*;
import lotto.Model.Lotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.HashMap;

public class ResultController {
    private OutputView outputView = new OutputView();
    private Singleton storage = Singleton.getInstance();

    public void checkResult(){
        HashMap<Rank, Integer> point = storage.myLotto.checkWinning(storage.winningLotto);
        int totalPrize = storage.myLotto.calculateTotalPrize(point);
        double profit = storage.cash.calculateProfit(totalPrize);
        outputView.printResult(point, profit);
    }
}
