package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    int lastIdx;
    int idx;

    ArrayIterator(T[] array) {
        this.array = array;
        lastIdx = array == null ? -1 : array.length - 1;
        idx = -1;
    }

    @Override
    public boolean hasNext() {
        return idx < lastIdx;
    }

    @Override
    public T next() {
        return array[++idx];
    }
}
