package lotto;

import lotto.Controller.ResultController;

public class Application {
    public static void main(String[] args) {
        ResultController mainController = new ResultController();
        try {
            mainController.inputCash();
            mainController.createMyLottos();
            mainController.printMyLottos();

            mainController.inputWinningLotto();
            mainController.calculateWinning();

            mainController.printResult();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
