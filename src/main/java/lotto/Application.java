package lotto;

import lotto.Controller.CreateLottoController;
import lotto.Controller.InputController;
import lotto.Controller.ResultController;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        CreateLottoController createLottoController = new CreateLottoController();
        ResultController resultController = new ResultController();
        try {
            inputController.inputCash();
            createLottoController.createMyLotto();
            inputController.inputWinningLotto();
            resultController.checkResult();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
