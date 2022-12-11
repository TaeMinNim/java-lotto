package lotto;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.createLotto();
            controller.checkWinning();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
