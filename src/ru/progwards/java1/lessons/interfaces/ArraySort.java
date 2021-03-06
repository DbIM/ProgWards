package ru.progwards.java1.lessons.interfaces;

public class ArraySort {
    public static void sort(CompareWeight[] a) {
        CompareWeight x;
        for (int i = 0, n = a.length; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (a[i].compareWeight(a[j]) == CompareWeight.CompareResult.GREATER) {
                    x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
    }
}
