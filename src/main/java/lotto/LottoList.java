package lotto;

import java.util.List;

public class LottoList {
    private List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    public WinPoint checkWin(Lotto winningLotto, int bonus){
        WinPoint winPoint = new WinPoint();
        for(Lotto lotto: lottoList){
            int match = winningLotto.countMatch(lotto);
            boolean hasBonus = lotto.hasBonus(bonus);
            Rank rank = Rank.checkRank(match, hasBonus);
            winPoint.increase(rank);
        }

        return winPoint;
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }
}
