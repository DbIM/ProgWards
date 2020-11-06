package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {


    private int[] array = new int[]{};

    public DIntArray(int[] array) {
        this.array = array;
    }

    int arrayLenght = array.length + 1;

    //добавляет элемент num в конец массива, при этом размер массива должен увеличиться на 1.
    // Для этого нужно будет разместить новый массив нужного размера,
    // скопировать в него старый, и добавить в хвост элемент num.
    public void add(int num) {
        int[] newArray = Arrays.copyOf(array, arrayLenght);
        newArray[arrayLenght] = num;
    }

    //добавляет элемент num в позицию pos массива, при этом размер массива должен увеличиться на 1.
    // Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый,
    // c учетом того, что новый элемент окажется где-то в середине,
    // и потом положить в нужный индекс элемент num.
    public void atInsert(int pos, int num) {
        int[] newArray = Arrays.copyOf(array, arrayLenght);
        newArray[pos] = num;
    }

    //удаляет элемент в позиции pos массива, при этом размер массива должен уменьшиться на 1.
    // Для этого нужно будет разместить новый массив нужного размера,
    // скопировать в него старый, уже без элемента, который был в позиции pos.
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
