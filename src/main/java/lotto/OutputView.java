package lotto;

import lotto.Wrapper.LottoList;
import lotto.Wrapper.Money;
import lotto.Wrapper.WinPoint;

public class OutputView {
    public void printLotto(LottoList lottoList){
        int count = lottoList.getLottoList().size();
        System.out.println(count + "개를 구매했습니다.");

        for(Lotto lotto: lottoList.getLottoList()){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(WinPoint winPoint, Money money){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winPoint.getValue(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + winPoint.getValue(Rank.FORTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winPoint.getValue(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winPoint.getValue(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winPoint.getValue(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + money.calculateProfit(winPoint) + "%입니다.");
    }
}
