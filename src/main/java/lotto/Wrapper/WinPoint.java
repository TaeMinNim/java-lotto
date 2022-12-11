package lotto.Wrapper;

import lotto.Rank;

import java.util.HashMap;
import java.util.Map;

public class WinPoint {
    private HashMap<Rank, Integer> winPoint;

    public WinPoint(){
        winPoint = new HashMap<>();
        for(Rank rank: Rank.values()){
            winPoint.put(rank, 0);
        }
    }

    public void increase(Rank rank){
        int point = winPoint.get(rank) + 1;
        winPoint.replace(rank, point);
    }

    public int getTotalPrize(){
        int totalPrize = 0;
        for(Map.Entry<Rank, Integer> entry: winPoint.entrySet()){
            Rank rank = entry.getKey();
            int count = entry.getValue();

            totalPrize += rank.getPrize() * count;
        }

        return totalPrize;
    }

    public int getValue(Rank rank){
        return winPoint.get(rank);
    }
}
