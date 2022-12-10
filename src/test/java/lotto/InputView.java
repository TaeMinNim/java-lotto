package lotto;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    public Money inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String string = Console.readLine();
        return new Money(string);
    }

    public Lotto inputWinningLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String string = Console.readLine();
        Numbers numbers = new Numbers(string);

        return new Lotto(numbers.getNumbers());
    }
}
