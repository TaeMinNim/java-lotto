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

    }

    public void calculateWinning() {
        int total = 0;

        profit = storage.cash.calculateProfit(total);
    }

    public void printResult() {
        outputView.printResult(point, profit);
    }
}
