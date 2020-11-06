package ru.progwards.java1.lessons.test;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] array = {2,1,3,5,0};
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int x;
                if (array[i] < array[j]) {
                    x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        int[] newArray = Arrays.copyOf(array, array.length - 1);
        System.out.println(Arrays.toString(newArray));
    }

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

    public static int arrayMax(int[] a){
        if (a.length == 0) {
            return 0;
        }
        int x = a.length - 1;
        Arrays.sort(a);
        return a[x];
    }

    public int sumArrayItems(int[] a){
        int k = 0;
        for(int i=0;i<a.length;i++){
            k+=a[i];
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

    static int addAsStrings(int n1, int n2){
        return Integer.parseInt((String.valueOf(n1) + String.valueOf(n2)));
    }

}

//Правильные ответы: int a[];,
// int []a = new int[10];,
// int []a = {10, 26, 12, 35};,
// int a[] = {11, 22, 33};//int item = a[1];,
// int a[][][];,
// int a1[], a2[], a3[];
//int a[][] = {a1, a2, a3};,
//int a[][];//int item = a[1][2];

//Правильные ответы: Массив это хранилище объектов заданного типа,
// Размер массива задается при создании, и не может быть изменен в дальнейшем,
// Размер массива можно узнать через свойство length

