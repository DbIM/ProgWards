package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {

    private int[] array;

/*    public DIntArray(int[] array) {
        this.array = array;
    }*/

    public DIntArray() {
    }

    public void add(int num) {
        int[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = num;
    }

    public void atInsert(int pos, int num) {
        int[] newArray = Arrays.copyOf(array, array.length);
        newArray[pos] = num;
    }

    public void atDelete(int pos) {
        array[pos] = 0;
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
    }

    //возвращает элемент по индексу pos.
    public int at(int pos) {
        return array[pos];
    }
}
