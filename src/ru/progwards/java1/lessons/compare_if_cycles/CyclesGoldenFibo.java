package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static void main(String[] args) {
        int z = 2;
        for (int i = 1; i <= 15; i++) {
            System.out.println(fiboNumber(i));
            if (fiboNumber(i) <= 100) {
                System.out.println("Треугольник со сторонами " + fiboNumber(i) + " и " + fiboNumber(z) );
                System.out.println(isGoldenTriangle(fiboNumber(i), fiboNumber(i), fiboNumber(z)));
                z++;
            }
        }
    }

    public static boolean containsDigit(int number, int digit) {
        while (number != 0) {
            int i = number % 10;
            number /= 10;
            if (digit == i) {
                return true;
            }
        }
        return false;
    }

    public static int fiboNumber(int n) {
        int z = 0;
        int i = 1;
        int k = 0;
        int tryNum = 0;
        while (tryNum != n) {
            i = i + z;
            tryNum += 1;
            z = k;
            k = i;
        }
        return i;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        if (a == b && b != c) {
            if (a / c >= 1.61703 && a / c <= 1.61903) {
                return true;
            }
        } else if (a == c && a != b) {
            if (a / b >= 1.61703 && a / b <= 1.61903) {
                return true;
            }
        } else if (b == c && a != c) {
            if (b / a >= 1.61703 && b / a <= 1.61903) {
                return true;
            }
        }
        return false;
    }

}
