package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Creator {
    //создать коллекцию и заполнить последовательностью четных
    // возрастающих чисел начиная с 2,
    // количество элементов в коллекции n
    public static Collection<Integer> fillEven(int n) {
        Collection<Integer> result = new ArrayList();
        int x = 2;
        for (int i = n; i > 0; i--, x += 2) result.add(x);
        return result;
    }

    //создать коллекцию и заполнить последовательностью нечетных убывающих чисел,
// минимальное число в коллекции 1, количество элементов в коллекции n
    public static Collection<Integer> fillOdd(int n) {
        Collection<Integer> result = new ArrayList();
        int x = n * 2 - 1;
        for (int i = n; i > 0; i--, x -= 2) result.add(x);
        return result;
    }
    //создать коллекцию и заполнить ее тройками чисел.
    // Каждая тройка создается по алгоритму: первое число тройки - индекс числа в коллекции,
    // второе - тот же индекс в квадрате,
    // третье - тот же индекс в кубе,
    // количество элементов в коллекции n*3
    public static Collection<Integer> fill3(int n) {
        Collection<Integer> result = new ArrayList();
        for (int i = 0; i <  n; i++) {
            int x = i * 3;
            result.add(x);
            result.add(x * x);
            result.add(x * x * x);
        }
        return result;
    }

    public static void main(String[] args) {
        Collection<Integer> t = fill3(4);
    }

}
