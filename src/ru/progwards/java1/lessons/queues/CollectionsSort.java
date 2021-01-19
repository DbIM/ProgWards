package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {
    //1.1 Реализовать метод public static void mySort(Collection<Integer> data) -
    // переделать алгоритм из класса ArraySort из ДЗ про массивы, на коллекции.
    // Не использовать встроенные методы сортировок
    public static void mySort(Collection<Integer> data) {
        for (int i = 0; i < data.size(); i++) {
            Iterator<Integer> iterator = data.iterator();
            Integer x = iterator.next();
            for (int j = i + 1; j < data.size(); j++) {
                Integer y = iterator.next();
                if (x.compareTo(y) > 0)
                    Collections.swap((List) data, ((List<Integer>) data).indexOf(x), ((List<Integer>) data).indexOf(y));
            }
        }
    }

    //1.2 Реализовать метод public static void minSort(Collection<Integer> data) по следующему алгоритму
    //- создать новую коллекцию
    //- найти минимальный элемент с использованием функции min()
    //- переместить его в новую коллекцию
    //- делать так до тех пор, пока все элементы не окажутся в новой коллекции
    //- скопировать новую коллекцию в старую
    public static void minSort(Collection<Integer> data) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!data.isEmpty()) {
            int minimum = Collections.min(data);
            arrayList.add(minimum);
            data.remove(minimum);
        }
        data.addAll(arrayList);
    }

    //1.3 Реализовать метод public static void collSort(Collection<Integer> data) используя метод sort из Collections
    public static void collSort(Collection<Integer> data) {
        ArrayList<Integer> arrayList = new ArrayList<>(data);
        Collections.sort(arrayList);
        data.clear();
        data.addAll(arrayList);
    }

    //1.4 Реализовать метод public static Collection<String> compareSort()
    // в котором сравнить производительность методов и вернуть их имена,
    // отсортированные в порядке производительности,
    // первый - самый быстрый.
    // В случае равенства производительности каких-то методов, возвращать их названия в алфавитном порядке.
    public static Collection<String> compareSort() {
        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i< 1_0000; i++) {
            Collections.addAll(list, rnd.nextInt());
        }
        long start = System.currentTimeMillis();
        mySort(list);
        long mySortTime = System.currentTimeMillis() - start;
        long start2 = System.currentTimeMillis();
        minSort(list);
        long minSortTime = System.currentTimeMillis() - start2;
        long start3 = System.currentTimeMillis();
        collSort(list);
        long collSortTime = System.currentTimeMillis() - start3;
        List<String> list2 = new ArrayList<>();
        if (mySortTime == minSortTime && minSortTime == collSortTime) {
            list2.add("collSort");
            list2.add("minSort");
            list2.add("mySort");
        }
        if (mySortTime == minSortTime) {
            list2.add("collSort");
            list2.add("minSort");
            list2.add("mySort");
        }
        else {
            list2.add("collSort");
            list2.add("minSort");
            list2.add("mySort");
        }

        return list2;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 5, 4, 3, 2, 1, 6, 8, 9);
        //mySort(list);
        //minSort(list);
        //collSort(list);
        //System.out.println(list);
        System.out.println(compareSort());
    }
}
