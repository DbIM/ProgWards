package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class ArrayInteger {
    byte[] digits;

    ArrayInteger(int n){
        digits = new byte[n];
    }
}


//Реализовать класс ArrayInteger - целого числа произвольной длины на массиве byte[] digits;
// Каждый элемент массива digits[i] может хранить только цифру, то есть число от 0 до 9.
// Например, число 159 должно занять 3 ячейки массива digits[0] = 9; digits[1] = 5; digits[2] = 1;
//
//Реализовать методы:
//3.1 ArrayInteger(int n) - инициализирует класс, с максимальной точностью n цифр (размер массива)
//
//3.2 void fromInt(BigInteger value) - установить свое значение, взяв его из value
// (уложить BigInteger во внутренний массив)
//
//3.3 BigInteger toInt() - привести свое значение к BigInteger (преобразовать из массива в BigInteger)
//
//3.4 boolean add(ArrayInteger num) - сложить 2 числа, не используя BigInteger,
// а  используя массив digits, результат поместить в экземпляр ArrayInteger,
// у которого был вызван метод. При переполнении вернуть false, при этом само число сбросить в 0