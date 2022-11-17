package lotto.Model;

import lotto.Rank;

import java.util.HashMap;
import java.util.List;

public class MyLotto {
    private List<Lotto> myLotto;
    private HashMap<Rank, Integer> point;

    public MyLotto(List<Lotto> myLotto){
        this.myLotto = myLotto;
        point = new HashMap<Rank, Integer>();
        point.put(Rank.FIRST, 0);
        point.put(Rank.SECOND, 0);
        point.put(Rank.THIRD, 0);
        point.put(Rank.FOURTH, 0);
        point.put(Rank.FIFTH, 0);
        point.put(Rank.LAST, 0);
    }

    public HashMap<Rank, Integer> checkWinning(WinningLotto winningLotto){
        for (Lotto myLotto : myLotto) {
            int match = winningLotto.countMatch(myLotto);
            boolean hasBonus = winningLotto.containBonus(myLotto);
            Rank rank = Rank.getMyRank(match, hasBonus);
            int p = point.get(rank);
            point.replace(rank, p + 1);
        }

        return point;
    }

    public int quantity(){
        return myLotto.size();
    }

    public List<Lotto> getMyLotto(){
        return myLotto;
    }
}
