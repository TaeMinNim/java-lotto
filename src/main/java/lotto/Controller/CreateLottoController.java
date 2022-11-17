package lotto.Controller;

import lotto.Model.LottoGeneratorModel;
import lotto.Singleton;
import lotto.View.OutputView;

public class CreateLottoController {
    Singleton storage = Singleton.getInstance();
    LottoGeneratorModel lottoGenerator = new LottoGeneratorModel();
    OutputView outputView = new OutputView();

    public void createMyLotto() {
        int lottoNumber = storage.cash.calculateLottoCount();
        storage.myLotto = lottoGenerator.createMyLotto(lottoNumber);
        outputView.printMyLottoInfo(storage.myLotto);
    }
}
