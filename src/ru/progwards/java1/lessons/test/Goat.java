package ru.progwards.java1.lessons.test;

//Вы правильно выбрали 2.
//Правильные ответы:
// невозможно создать экземпляр абстрактного класса,
// класс-наследник абстрактного класса либо сам должен быть абстрактным, либо реализовать все абстрактные методы,
// interface позволяет использовать унифицированный доступ к классам, не связанным иерархией наследования


public class Goat implements Speaking, Eating {
    @Override
    public String say() {
        return "Мее";
    }

    @Override
    public String eat() {
        return "Сено";
    }
}



//class Circle {
//   private double radius;
//}
//
//по параметру radius;
//
//public boolean equals(Object o) {
//[if (this == o) return true;]
//[if (o == null) return false;]
//[if( GetClass != o.GteClass()) return false;]
//[double radius = ((Circle)o).radius;]
//return [Double.compareTo(this,radius, radius) == 0;]
//}

//Ваш ответ верный.
//Правильный ответ: public final class Number {
//...
//} → у этого класса не может быть потомков,
// public abstract class Number {
//...
//} → нельзя создать экземпляр этого класса,
// public class Number implements Comparable {
//...
//} → этот класс обязан реализовать все методы из Comparable,
// public abstract final class Number {
//...
//} → так нельзя, компилятор выдаст ошибку,
// public class Number implements ICompare {
//...
//} → можно написать ICompare i = new Number();