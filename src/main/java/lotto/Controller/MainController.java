package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.*;
import lotto.Model.Cash;
import lotto.Model.Lotto;
import lotto.Model.LottoGeneratorModel;
import lotto.Model.WinningLotto;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainController {
    private Cash cash;
    private int lottoNumber;
    private List<Lotto> myLottos;
    private WinningLotto winningLotto;
    private HashMap<Rank, Integer> point;
    private double profit;

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

        cash = new Cash(integer);
    }

    public void createMyLottos() {
        lottoNumber = cash.calculateLottoCount();
        LottoGeneratorModel lottoGenerator = new LottoGeneratorModel();
        myLottos = lottoGenerator.createMyLottos(lottoNumber);
    }

    public void printMyLottos() {
        OutputView outputView = new OutputView();
        outputView.printMyLottoInfo(myLottos);
    }

    public void inputWinningLotto() throws IllegalArgumentException {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        winningLotto = new WinningLotto(winningNumber, bonusNumber);
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
        for (Lotto myLotto : myLottos) {
            int match = winningLotto.countMatch(myLotto);
            boolean hasBonus = winningLotto.containBonus(myLotto);
            Rank rank = Rank.getMyRank(match, hasBonus);
            total += rank.getPrize();
            int p = point.get(rank);
            point.replace(rank, p + 1);
        }

        profit = cash.calculateProfit(total);
    }

    public void printResult() {
        OutputView outputView = new OutputView();
        outputView.printResult(point, profit);
    }
}
