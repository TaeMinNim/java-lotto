package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.*;
import lotto.Model.Cash;
import lotto.Model.Lotto;
import lotto.Model.LottoGeneratorModel;
import lotto.Model.WinningLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainController {
    private HashMap<Rank, Integer> point;
    private double profit;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoGeneratorModel lottoGenerator = new LottoGeneratorModel();
    private Singleton storage = Singleton.getInstance();
    public MainController() {
        point = new HashMap<Rank, Integer>();
        point.put(Rank.FIRST, 0);
        point.put(Rank.SECOND, 0);
        point.put(Rank.THIRD, 0);
        point.put(Rank.FOURTH, 0);
        point.put(Rank.FIFTH, 0);
        point.put(Rank.LAST, 0);
    }

    public void inputCash() throws IllegalArgumentException {
        String input = Console.readLine();
        int integer;
        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }

        storage.cash = new Cash(integer);
    }

    public void createMyLottos() {
        int lottoNumber = storage.cash.calculateLottoCount();
        storage.myLotto = lottoGenerator.createMyLottos(lottoNumber);
    }

    public void printMyLottos() {
        outputView.printMyLottoInfo(storage.myLotto);
    }

    public void inputWinningLotto() throws IllegalArgumentException {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        storage.winningLotto = new WinningLotto(winningNumber, bonusNumber);
    }

    private List<Integer> inputWinningNumber() throws IllegalArgumentException{
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winningNumber = new ArrayList<>();
        for (String number : numbers) {
            try {
                winningNumber.add(Integer.parseInt(number));
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
            }
        }

        return winningNumber;
    }

    private int inputBonusNumber() throws IllegalArgumentException {
        String input = Console.readLine();

        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }

        return bonusNumber;
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
