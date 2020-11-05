package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a, b;

    ComplexNum(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString(){
        return (a + "+" + b + "i");
    }


    public ComplexNum add(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum(num1.a + num2.a, num1.b + num2.b);
    }

    public ComplexNum sub(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum(num1.a - num2.a, num1.b - num2.b);
    }

    public ComplexNum mul(ComplexNum num1, ComplexNum num2) {
        int a = num1.a, b = num1.b, c = num2.a, d = num2.b;
        return new ComplexNum(a * c - b * d, b * c + a * d);
    }

    public ComplexNum div(ComplexNum num1, ComplexNum num2) {
        int a = num1.a, b = num1.b, c = num2.a, d = num2.b;
        return new ComplexNum((a * c + b * d) / (c * c + d * d),
                (b * c - a * d) / (c * c + d * d));
    }
}
