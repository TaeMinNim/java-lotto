package lotto;

public class OutputView {
    public void printLotto(LottoList lottoList){
        int count = lottoList.getLottoList().size();
        System.out.println(count + "개를 구매했습니다.");

        for(Lotto lotto: lottoList.getLottoList()){
            System.out.println(lotto.getNumbers());
        }
    }
}
