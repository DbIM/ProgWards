package ru.progwards.java1.lessons.Lesson9;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

class Person {
    public String name;
    public Person(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        BigDecimal bigDec1 = BigDecimal.valueOf(10);
        BigDecimal bigDec2 = BigDecimal.valueOf(3);
        BigDecimal result = bigDec1.divide(bigDec2, 5, RoundingMode.HALF_UP);
        System.out.println(result);

        MathContext mathContext = new MathContext(3);
        BigDecimal result2 = new BigDecimal("3.3333", mathContext);
        System.out.println(result2);

    }
}




