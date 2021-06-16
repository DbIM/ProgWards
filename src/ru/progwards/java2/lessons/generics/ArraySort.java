package ru.progwards.java2.lessons.generics;

public class ArraySort {
    public static <T extends Comparable<T>> void sort(T[] args) {
        for(int i = 0; i < args.length-1; i++) {
            for(int j = i+1; j < args.length; j++) {
                if(args[i].compareTo(args[j]) > 0) {
                    T temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }
    }
}
