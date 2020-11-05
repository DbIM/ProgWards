package ru.progwards.java1.lessons.arrays;

public class ArraySort {
    public static void sort(int[] a){
        for (int i=0;i<a.length;i++){
            for (int j = i +1; j<a.length; j++){
                int x;
                if (a[i] < a[j]){
                    x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
    }
}
