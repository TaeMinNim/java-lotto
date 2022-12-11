package lotto;

import lotto.Util.Number;
import lotto.Wrapper.LottoList;
import lotto.Wrapper.Money;
import lotto.Wrapper.WinPoint;

public class Controller {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoGenerator lottoGenerator = new LottoGenerator();
    private Money money;
    private LottoList lottoList;
    private Lotto winningLotto;
    private int bonus;

    public void createLotto(){
        money = inputView.inputMoney();
        lottoList = lottoGenerator.createLotto(money.count());
        outputView.printLotto(lottoList);
    }

    public void checkWinning(){
        winningLotto = inputView.inputWinningLotto();
        bonus = inputView.inputBonus().getNumber();
        WinPoint winPoint = lottoList.checkWin(winningLotto, bonus);
        outputView.printResult(winPoint, money);
    }
}
