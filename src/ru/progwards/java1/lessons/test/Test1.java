package ru.progwards.java1.lessons.test;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int i = 9 ;
        System.out.println(i%2);
        }
    }

/*    public enum Grade {
        VERYBAD,
        BAD,
        SATISFACTORILY,
        GOOD,
        EXCELLENT,
        NOTDEFINED
    }

    static Grade intToGrade(int grade) {
        switch (grade) {
            case 1: return Grade.VERYBAD;
            case 2: return Grade.BAD;
            case 3: return Grade.SATISFACTORILY;
            case 4: return Grade.GOOD;
            case 5: return Grade.EXCELLENT;
            default: return Grade.NOTDEFINED;
        }
    }*/

    ;
//Вы правильно выбрали 2.
//Правильные ответы:
// Перечисление (enum) можно использовать в конструкции switch case,
// Использование перечислений (enum) повышает наглядность кода,
// При написании элементов enum желательно использовать стиль для констант

/*
    public static void reverse(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int x;
                if (a[i] < a[j]) {
                    x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
    }

    public static int arrayMax(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        int x = a.length - 1;
        Arrays.sort(a);
        return a[x];
    }

    public int sumArrayItems(int[] a) {
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            k += a[i];
        }
        return k;
    }

    static String textGrade(int grade) {
        if (grade == 0) {
            return ("не оценено");
        } else if (grade >= 1 && grade <= 20) {
            return ("очень плохо");
        } else if (grade >= 21 && grade <= 40) {
            return ("плохо");
        } else if (grade >= 41 && grade <= 60) {
            return ("удовлетворительно");
        } else if (grade >= 61 && grade <= 80) {
            return ("хорошо");
        } else if (grade >= 81 && grade <= 100) {
            return ("отлично");
        } else {
            return ("не определено");
        }
    }

    static long factorial(long n) {
        long i = 1;
        if (n == 0) {
            return (1);
        } else {
            while (n >= 1) {
                i = i * n;
                n--;
            }
            return i;
        }
    }

    static int addAsStrings(int n1, int n2) {
        return Integer.parseInt((String.valueOf(n1) + String.valueOf(n2)));
    }

}
*/

// int a[];,
// int []a = new int[10];,
// int []a = {10, 26, 12, 35};,
// int a[] = {11, 22, 33};//int item = a[1];,
// int a[][][];,
// int a1[], a2[], a3[];//int a[][] = {a1, a2, a3};,
//int a[][];//int item = a[1][2];

