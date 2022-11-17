package lotto.Model;

/* 구매 금액의 Type으로 사용되는 클래스입니다 */

public class Cash {
    private final static int MIN_UNIT = 1000;
    private int cash;

    public Cash(int cash) {
        isValidData(cash);
        this.cash = cash;
    }

    private void isValidData(int cash) throws IllegalArgumentException {
        final int UNIT = 1000;

        if (cash <= 0) {
            throw new IllegalArgumentException("양수만 허용합니다");
        }
        if ((cash % UNIT) != 0) {
            throw new IllegalArgumentException("1000원 단위 금액을 입력해주세요");
        }
    }

    public int calculateLottoCount() {
        return cash / MIN_UNIT;
    }

    public double calculateProfit(int totalPrize) {
        double profit = ((double) totalPrize / cash) * 100 * 10;
        profit = Math.round(profit);

        return profit / 10;
    }
}
