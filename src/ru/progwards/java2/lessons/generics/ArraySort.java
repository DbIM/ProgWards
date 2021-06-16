package ru.progwards.java2.lessons.generics;

public class ArraySort {
    public static <T extends Comparable<T>> void sort(T[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            for (int i2 = i + 1; i2 < args.length; i2++) {
                if (args[i].compareTo(args[i2]) > 0) {
                    T temp = args[i];
                    args[i] = args[i2];
                    args[i2] = temp;
                }
            }
        }
    }
}
