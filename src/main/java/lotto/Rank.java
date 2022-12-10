package lotto;

public enum Rank {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FORTH(50_000, 4),
    FIFTH(5_000, 3);

    private final int prize;
    private final int match;
    Rank(int prize, int match){
        this.prize = prize;
        this.match = match;
    }
}
