package lotto.Model;

import lotto.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

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

    public int calculateTotalPrize(HashMap<Rank, Integer> point){
        Set<Rank> keys = point.keySet();
        int totalPrize = 0;
        for(Rank rank : keys){
            int prize = rank.getPrize();
            int count = point.get(rank);
            totalPrize += prize * count;
        }

        return totalPrize;
    }

    public int quantity(){
        return myLotto.size();
    }

    public List<Lotto> getMyLotto(){
        return myLotto;
    }
}
