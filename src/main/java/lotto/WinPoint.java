package lotto;

import java.util.HashMap;

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
}
