package lotto;

/* 등수에 관한 Enum 입니다 */

public enum Rank {
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6),
    LAST(0, 0);

    private final int prize;
    private final int match;


    private Rank(int prize, int match) {
        this.prize = prize;
        this.match = match;
    }

    public static Rank getMyRank(int match, boolean bonus) {
        if (Rank.THIRD.isSameMatch(match)) {
            if (bonus) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }

        for (Rank rank : Rank.values()) {
            if (rank.isSameMatch(match)) {
                return rank;
            }
        }

        return Rank.LAST;
    }

    public int getPrize() {
        return this.prize;
    }

    private boolean isSameMatch(int match){
        return this.match == match;
    }

}