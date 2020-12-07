package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

//Реализовать алгоритм быстрого возведения в степень pow
// числа num в BigDecimal
public class BigAlgebra {
    static BigDecimal fastPow(BigDecimal num, int pow) {
        BigDecimal k1 = num;
        BigDecimal k2;
        if (pow % 2 == 1) {
            int pow2 = ((pow - 1) / 2);
            for (int i = 1; i < pow2; i++) {
                k1 = k1.multiply(num);
            }
            k2 = k1.multiply(k1).multiply(num);
            return k2;
        }
        int pow2 = pow / 2;
        for (int i = 1; i < pow2; i++) {
            k1 = k1.multiply(num);
        }
        k2 = k1.multiply(k1);
        return k2;
    }

    //Реализовать алгоритм вычисления n-го числа фибоначчи в BigInteger.
    static BigInteger fibonacci(int n) {
        if (n < 3) {
            return BigInteger.ONE;
        }
        return fibonacci(n -2).add(fibonacci(n - 1));
    }

/*       public static void main(String[] args) {
        BigDecimal x = new BigDecimal("2");
        System.out.println(fastPow(x, 11));
        for (int i = 1; i<30;i++) {
            System.out.println(fibonacci(i));
        }
    }*/
}

