package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int[] array = new int[]{};
    private int[] getArray() {
        return array;
    }


    public void add(int num) {
        int[] arrayCopy = Arrays.copyOf(getArray(), getArray().length + 1);
        arrayCopy[arrayCopy.length - 1] = num;
        array = arrayCopy;
    }

    public void atInsert(int pos, int num) {
        int[] arrayCopy = new int[array.length + 1];
        for (int i = 0; i < arrayCopy.length; i++) {
            if (i < pos) {
                arrayCopy[i] = array[i];
            } else if (i == pos) {
                arrayCopy[i] = num;
            } else {
                arrayCopy[i] = array[i - 1];
            }
        }
        array = arrayCopy;
    }


    public void atDelete(int pos) {
        int[] arrayCopy = new int[getArray().length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i < pos) {
                arrayCopy[i] = array[i];
            } else if (i > pos) {
                arrayCopy[i - 1] = array[i];
            }
        }
        array = arrayCopy;
    }

    public int at(int pos) {
        return array[pos];
    }
}