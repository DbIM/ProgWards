package ru.progwards.java1.lessons.Lesson14;

import java.util.*;

public class Lesson {
    static long codeStart = System.currentTimeMillis();
    static final int ELEM = 5_000_000;
    public static void main(String[] args) {

        Queue<Double> priQueue = new PriorityQueue<>();
        ArrayList<Double> arrayList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i<ELEM; i++) priQueue.offer(rnd.nextDouble());
        for (int i=0; i<ELEM; i++) arrayList.add(rnd.nextDouble());
        Collections.sort(arrayList);

        long start = System.currentTimeMillis();
        for (int i =0; i<ELEM;i++) priQueue.poll();
        System.out.println("Чтение элементов из PriorityQueue: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i =0; i<ELEM;i++) arrayList.get(i);
        System.out.println("Чтение элементов из ArrayList: " + (System.currentTimeMillis() - start));

        System.out.println("Общее время работы программы: " + (System.currentTimeMillis() - codeStart));
    }

    int sumLastAndFirst(ArrayDeque<Integer> deque){
        if (deque.size() == 0) return 0;
        return  deque.getFirst() + deque.getLast();
    }

    ArrayDeque<Integer> array2queue(int[] a){
        ArrayDeque deque = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            deque.offer(a[i]);
        }
        return deque;
    }

     /*    ArrayDeque deque = new ArrayDeque<>();
        for (int i = 0; i <= 10; i++) {
            deque.offer(i);
            if (i%2 == 0)
                deque.poll();
        }
        System.out.println(deque);*/
        //[6, 7, 8, 9, 10]

/*      PriorityQueue pQueue = new PriorityQueue<>();
        pQueue.offer(10);
        pQueue.offer(1);
        pQueue.offer(9);
        pQueue.offer(3);
        System.out.println(pQueue);*/
        //[1, 3, 9, 10]
}

//Правильные ответы:
// Очередь работает по принципу FIFO - First In First Out,
// ArrayDeque быстро добавляет элементы в конец очереди,
// element и remove бросают исключения

//Правильные ответы:
// Двусторонняя очередь работает по принципу LIFO - Last In First Out,
// Двусторонняя очередь работает по принципу FIFO - First In First Out,
// ArrayDeque позволяет избежать копирования массивов при добавлении и удалении

//Правильный ответ:
// Сортирует список list → void sort(List<T> list),
// Возвращает компаратор, обратный заданному cmp → Comparator<T> reverseOrder(Comparator<T> cmp),
// Меняет порядок элементов в списке list на обратный → void reverse(List<?> list),
// Перетасовывает список list случайным образом → void shuffle(List<?> list),
// Возвращает обратный компаратор → Comparator<T> reverseOrder(),
// Перетасовывает список list случайным образом на основе генератора ПСЧ rnd → void shuffle(List<?> list, Random rnd),
// Сортирует список list с использованием компаратора c → void sort(List<T> list, Comparator<? super T> c)

//Правильный ответ:
//Копирует все элементы списка src  в список dest → void copy(Listt<? super T> dest, List<? extends T> src),
// Возвращает immutable список из n элементов o → List nCopies(int n, T o),
//Наполняет список list элементом obj → void fill(List<? super T> list, T obj),
// Добавляет все elements в указанную коллекцию c → boolean addAll(Collection<? super T> c, T... elements)

//Правильный ответ:
// Сортирует список list с использованием компаратора c → void sort(List<T> list, Comparator<? super T> c),
// Меняет порядок элементов в списке list на обратный → void reverse(List<?> list),
// Перетасовывает список list случайным образом на основе генератора ПСЧ rnd → void shuffle(List<?> list, Random rnd),
// Сортирует список list → void sort(List<T> list), Возвращает обратный компаратор → Comparator<T> reverseOrder(),
// Перетасовывает список list случайным образом → void shuffle(List<?> list),
// Возвращает компаратор, обратный заданному cmp → Comparator<T> reverseOrder(Comparator<T> cmp)

//Правильный ответ:
// Возвращает количество вхождений объекта o в коллекцию c → int frequency(Collection<?> c, Object o),
// Рокировка элементов списка list с индексами i и j → void swap(List<?> list, int i, int j),
// Меняет в списке list все элементы oldVal на newVal → boolean replaceAll(List<T> list, T oldVal, T newVal),
// Возвращает true, если коллекции c1 и c2 не имеют одинаковых элементов → boolean disjoint(Collection<?> c1, Collection<?> c2),
// Ротация элементов списка list на distance элементов → void rotate(List<?> list, int distance)

//Правильный ответ:
// Максимальный элемент коллекции coll → T max(Collection<? extends T> coll),
// Найти в списке source последнее вхождение подсписка target → int lastIndexOfSubList(List<?> source, List<?> target),
// Найти в списке source первое вхождение подсписка target → int indexOfSubList(List<?> source, List<?> target),
// Минимальный элемент коллекции coll → T min(Collection<? extends T> coll),
// Быстрый поиск в отсортированном списке list элемента key → int binarySearch(List<? extends Comparable<? super T>> list, T key)