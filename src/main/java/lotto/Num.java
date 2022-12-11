package lotto;

public class Num {
    private final static int MIN = 1;
    private final static int MAX = 45;

    private int num;

    public Num(int num){
        validData(num);
        this.num = num;
    }

    private void validData(int num){
        if(!(num >= MIN && num <= MAX)){
            throw new IllegalArgumentException("1~45 사이의 숫자이어야 합니다.");
        }
    }

    public int getNum(){
        return num;
    }
}
