package lotto;

public enum Rank {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FORTH(50_000, 4),
    FIFTH(5_000, 3),
    LAST(0, 0);
    private final int prize;
    private final int match;
    Rank(int prize, int match){
        this.prize = prize;
        this.match = match;
    }

    public static Rank checkRank(int match, boolean bonus){
        if(match == SECOND.match){
            if(bonus){
                return SECOND;
            }
            return THIRD;
        }

        for(Rank rank: Rank.values()){
            if(rank.match == match){
                return rank;
            }
        }

        return LAST;
    }

    public int getPrize(){
        return prize;
    }
}
