package ru.progwards.java1.lessons.test;

public class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a*b;
    }

    public int compareTo(Rectangle anRectangle) {
        if (this.area() > anRectangle.area()){
            return (1);
        }
        else  if (this.area() < anRectangle.area()){
            return (-1);
        }
        return (0);
    }


    public static void main(String[] args) {
        System.out.println(new Rectangle(2,3).compareTo(new Rectangle(3, 2)));
    }
}
