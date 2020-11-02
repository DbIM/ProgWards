package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static void main(String[] args) {
        System.out.println(isTriangle(3, 2, 5));
    }

    public static boolean isTriangle(int a, int b, int c){
        if (a < b + c && b < a + c && c < a + b) {
            return (true);
        }
        else
            return (false);
    }

    public static boolean isRightTriangle(int a, int b, int c){
        if (((a*a) == (b*b) + (c*c)) || ((b*b) == (a*a) + (c*c)) || ((c*c) == (b*b) + (a*a))) {
            return (true);
        }
        else
            return (false);
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c){
        if ((a == b) || (b == c) || (a == c)) {
            return (true);
        }
        else
            return (false);
    }
}
