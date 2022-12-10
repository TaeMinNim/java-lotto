package lotto;

public class Money {
    private final static int UNIT = 1000;
    private int money;

    public Money(String string){
        validData(string);
        this.money = Integer.parseInt(string);
    }

    private void validData(String string){
        int money;
        try{
            money = Integer.parseInt(string);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("올바른 값을 입력해주세요.");
        }
        if(money < 1000){
            throw new IllegalArgumentException("1000원 이상의 값을 입력해주세요.");
        }
        if(!(money % UNIT == 0)){
            throw new IllegalArgumentException("1000원 단위의 값을 입력해주세요.");
        }
    }

    public int count(){
        return money / UNIT;
    }

    public float calculateProfit(WinPoint winPoint){
        int totalPrize = winPoint.getTotalPrize();
        return (float)totalPrize / money;
    }
}
