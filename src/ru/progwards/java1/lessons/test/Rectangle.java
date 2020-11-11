package ru.progwards.java1.lessons.test;

import java.util.Objects;

public class Rectangle {
    public static void main(String[] args) {
        System.out.println(new Rectangle(2,3).equals(new Rectangle(3, 2)));
        System.out.println(new Rectangle(3,3).equals(new Rectangle(2, 2)));
        System.out.println(new Rectangle(3,4).equals(new Rectangle(6, 2)));
        System.out.println(new Rectangle(2,2).equals(new Rectangle(2, 2)));
        System.out.println(new Rectangle(2,2).equals(null));
        System.out.println(new Rectangle(2,2).equals(new Object()));
    }



    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a * b;
    }

    public int compareTo(Rectangle anRectangle) {
        if (this.area() > anRectangle.area()) {
            return (1);
        } else if (this.area() < anRectangle.area()) {
            return (-1);
        }
        return (0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.area(), area()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }


    //Правильные ответы:
    // Хеш-код предназначен для повышение быстродействия при поиске, добавлении и удалении элементов в коллекциях,
    // public boolean equals(Object o) обладает свойствами - транзитивность, рефлексивность и симметричность,
    // a.equals(null) всегда false
}
