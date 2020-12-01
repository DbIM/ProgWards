package ru.progwards.java1.lessons.Lesson9;

import java.math.BigDecimal;

public class Rectangle {
        Rectangle(BigDecimal a, BigDecimal b) {
            this.a = a;
            this.b = b;
        }
        public BigDecimal a;
        public BigDecimal b;

    boolean rectCompare(Rectangle r1, Rectangle r2){
        BigDecimal square1 = r1.a.multiply(r1.b);
        BigDecimal square2 = r2.a.multiply(r2.b);
        return square1.equals(square2);
    }
}

//Вы правильно выбрали 2.
//Правильные ответы:
// BigDecimal – класс для точных вычислений в дробных числах,
// BigInteger – класс для точных вычислений в целых числах,
// Для BigDecimal хранится unscaledValue и scale (масштаб)