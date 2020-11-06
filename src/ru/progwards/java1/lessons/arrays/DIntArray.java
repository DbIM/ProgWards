package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int[] arr = new int[]{};

    public void add(int num) {

        if (num > arr.length) {
            return;
        }

        int[] arrayInt = new int[]{};
        arrayInt = Arrays.copyOf(arr, arr.length + 1);
        arrayInt[arrayInt.length - 1] = num;
    }

    public void atInsert(int pos, int num) {
        int tempDigital = 0;
        int[] arrayIntIns = Arrays.copyOf(arr, arr.length + 1);


        tempDigital = arrayIntIns[pos];
        arrayIntIns[pos] = num;
        arrayIntIns[arrayIntIns.length - 1] = tempDigital;
    }


    public void atDelete(int pos) {
        int j = 0;
        int arrayIntDel[] = new int[arr.length - 1];


        for (int i = 0; i < arr.length; i++) {
            if (i == pos) {
                arrayIntDel[j] = arr[i + 1];
            } else {
                arrayIntDel[j] = arr[i];
                j++;
            }
        }

    }

    public int at(int pos) {
        return arr[pos];
    }


}