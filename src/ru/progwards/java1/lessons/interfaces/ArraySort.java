package ru.progwards.java1.lessons.interfaces;

public class ArraySort {
    public static void sort(Comparable<Food>[] a) {
        Comparable x;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareTo((Food) a[j]) > 0) {
                    x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
    }
}
