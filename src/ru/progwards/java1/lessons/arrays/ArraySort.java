package ru.progwards.java1.lessons.arrays;

public class ArraySort{
    public static void sort(int[] a) {
        int x;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
    }
}
