package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
//Реализовать класс ArrayInteger - целого числа произвольной длины на массиве byte[] digits;
// Каждый элемент массива digits[i] может хранить только цифру, то есть число от 0 до 9.
// Например, число 159 должно занять 3 ячейки массива digits[0] = 9; digits[1] = 5; digits[2] = 1;
//
//Реализовать методы:
//3.1 ArrayInteger(int n) - инициализирует класс, с максимальной точностью n цифр (размер массива)
public class ArrayInteger {
    byte[] digits;
    boolean flag;

    ArrayInteger(int n){
        digits = new byte[n];
        flag = true;
    }

    //3.2 void fromInt(BigInteger value) - установить свое значение, взяв его из value
// (уложить BigInteger во внутренний массив)
    //value.divideAndRemainder(value);
    //деление
    void fromInt(BigInteger value){
        if (value.compareTo(BigInteger.ZERO)>=0) {
            flag = true;
        }
        else {
            flag = false;
        }
        BigInteger[] arr = {value.abs(),BigInteger.ZERO};
        int i = 0;
        while (i<digits.length && arr[0].compareTo(BigInteger.TEN)>=0){
            arr = arr[0].divideAndRemainder(BigInteger.TEN);
            digits[i] = arr[1].byteValue();
            i++;
        }
        if (i<digits.length) {
            digits[i] = arr[0].byteValue();
        }
    }
    //3.3 BigInteger toInt() - привести свое значение к BigInteger (преобразовать из массива в BigInteger)
    BigInteger toInt(){
        int i = 0;
        String s = "";
        char a;
        while (i<digits.length){
            a = (char) digits[i];
            s = "" + a;
            i++;
        }
        String result = "";
        for (int k = 0; k < s.length(); k++) {
            result = s.charAt(k) + "";
        }
        return new BigInteger(result);
    }

    //3.4 boolean add(ArrayInteger num) - сложить 2 числа, не используя BigInteger,
// а  используя массив digits, результат поместить в экземпляр ArrayInteger,
// у которого был вызван метод. При переполнении вернуть false, при этом само число сбросить в 0
    boolean add(ArrayInteger num){
        int x = digits.length;
        int y = num.digits.length;
        if (y > x) {
            return false;
        }
        int[] c = new int[x];
        for (int i=0; i < x; i++){
            c[i] = digits[i] + num.digits[i];
        }
        int z = c.length;
        if (z > x) {
            return false;
        }
        int i = 0;
        String s = "";
        char a;
        while (i<c.length){
            a = (char) c[i];
            s = "" + a;
            i++;
        }
        int resume = Integer.parseInt(s);
        new ArrayInteger(resume);
        return true;
    }

    public static void main(String[] args) {
        BigInteger x = new BigInteger("123");

    }
}
