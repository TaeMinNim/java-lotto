package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Cash;
import lotto.Model.WinningLotto;
import lotto.Singleton;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    private Singleton storage = Singleton.getInstance();

    public void inputCash() throws IllegalArgumentException {
        String input = Console.readLine();
        int integer;
        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }

        storage.cash = new Cash(integer);
    }

    public void inputWinningLotto() throws IllegalArgumentException {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        storage.winningLotto = new WinningLotto(winningNumber, bonusNumber);
    }

    private List<Integer> inputWinningNumber() throws IllegalArgumentException{
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winningNumber = new ArrayList<>();
        for (String number : numbers) {
            try {
                winningNumber.add(Integer.parseInt(number));
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
            }
        }

        return winningNumber;
    }

    private int inputBonusNumber() throws IllegalArgumentException {
        String input = Console.readLine();

        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }

        return bonusNumber;
    }
}
