package lotto.Model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGeneratorModel {
    public MyLotto createMyLotto(int lottoNumber) {
        List<Lotto> myLotto = new ArrayList<>();
        for (int i = 0; i < lottoNumber; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            myLotto.add(lotto);
        }

        return new MyLotto(myLotto);
    }
}
