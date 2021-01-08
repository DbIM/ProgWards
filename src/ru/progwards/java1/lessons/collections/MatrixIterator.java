package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;
    int len;
    int idx;
    int nextIdx;
    ArrayIterator<T> iterator;
    ArrayIterator<T> nextIterator;

    MatrixIterator(T[][] array) {
        this.array = array;
        len = array == null ? -1 : array.length;
        idx = -1;
        calcNextIterator();
        iterator = nextIterator;
        idx = nextIdx;
    }

    void calcNextIterator() {
        int i = idx + 1;
        while (i < len) {
            if (array[i] != null && array[i].length > 0) {
                nextIterator = new ArrayIterator<>(array[i]);
                nextIdx = i;
                return;
            }
            i++;
        }
        nextIterator = null;
    }

    @Override
    public boolean hasNext() {
        return nextIterator != null;
    }

    @Override
    public T next() {
        if (!iterator.hasNext()) {
            idx = nextIdx;
            iterator = nextIterator;
        }
        T result = iterator.next();
        if (!iterator.hasNext()) calcNextIterator();
        return result;
    }
}
