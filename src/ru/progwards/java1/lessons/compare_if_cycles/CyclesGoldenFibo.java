package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static void main(String[] args) {
        int z = 2;
        for (int i = 1; i <= 15; i++) {
            System.out.println(fiboNumber(i));
            if (fiboNumber(i) <= 100) {
                if (isGoldenTriangle(fiboNumber(z), fiboNumber(z), fiboNumber(i))) {
                    System.out.println("Треугольник со сторонами " + fiboNumber(z) + " и " + fiboNumber(i));
                }
                z++;
            }
        }
    }

    public static boolean containsDigit(int number, int digit) {
        if (number == 0 && digit == 0) {
            return true;
        }
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
            if ((double) a / c >= 1.61703d && (double) a / c <= 1.61903d) {
                return true;
            }
        } else if (a == c && a != b) {
            if ((double) a / b >= 1.61703d && (double) a / b <= 1.61903d) {
                return true;
            }
        } else if (b == c && a != c) {
            if ((double) b / a >= 1.61703d && (double) b / a <= 1.61903d) {
                return true;
            }
        }
        return false;
    }
}
