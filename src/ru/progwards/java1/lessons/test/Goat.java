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
