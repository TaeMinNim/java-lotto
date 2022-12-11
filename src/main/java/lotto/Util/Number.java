package lotto.Util;

public class Number {
    private final static int MIN = 1;
    private final static int MAX = 45;

    private final int number;

    public Number(String numberString){
        int number = trans(numberString);
        validData(number);
        this.number = number;
    }

    private int trans(String numberString) throws IllegalArgumentException{
        int number;
        try{
            number = Integer.parseInt(numberString);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 값을 입력해주세요");
        }

        return number;
    }

    private void validData(int number){
        if(!(number >= MIN && number <= MAX)){
            throw new IllegalArgumentException("1~45 사이의 숫자이어야 합니다.");
        }
    }

    public int getNumber(){
        return number;
    }
}
