package ru.progwards.java1.lessons.Lesson12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class lesson12 {
    public static List<Integer> listAction(List<Integer> list) {
        list.remove(list.indexOf(Collections.min(list)));
        list.add(0, list.size());
        list.add(2, Collections.max(list));
        return list;
    }


    public static List<Integer> filter(List<Integer> list) {
        //суммирует значения всех элементов списка
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        int test = sum / 100;
        List<Integer> result = new ArrayList<>();
        //удаляет из списка элементы, значение которых больше суммы,
        // деленной на 100 (целочисленное деление)
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= test) {
                result.add(list.get(i));
            }
        }
        //возвращает результирующий список
        return result;
    }

    public void iterator3(ListIterator<Integer> iterator){
        //который заменяет значение каждого элемента, которое кратно 3 на значение его индекса.
        while (iterator.hasNext()){
            Integer test = iterator.next();
            if(test % 3 == 0){
                iterator.set(iterator.nextIndex() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(filter(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
    }
}

//Правильный ответ:
// Интерфейс, для реализации хранилища объектов → Collection,
// Класс, реализующий полезные статические функции max, min, sort и др → Collections,
// Интерфейс для реализации множества → Set,
// Класс, реализующий динамический массив → ArrayList,
// Интерфейс для реализации списка → List,
// Интерфейс для реализации очереди → Queue

//Правильный ответ:
//((ArrayList)numbers).add(3, numbers.size());
//→ 0 1 2 5 3 4,
//numbers.add(Collections.min(numbers));
//→ 0 1 2 3 4 0,
//numbers.remove(3);
//→ 0 1 2 4,
//numbers.add(3, 5);
//→ Компилятор выдаст ошибку

//Правильные ответы:
// Добавление в конец списка,
// Удаление последнего элемента,
// Обращение к любому элементу

//Правильные ответы:
// Доступ в конец или начало,
// Добавление в начало или конец,
// Удаление из начала или конца

//Правильный ответ:
// ArrayList организован на основе → массива,
// LinkedList организован на основе  → двунаправленного списка

//Правильные ответы:
// ListIterator позволяет добавлять, удалять и менять элементы списка,
// ListIterator позволяет двигаться по списку в обе стороны,
// ListIterator отличается от Iterator расширенным набором функций

//Правильный ответ:
//        for (ListIterator<integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
//            Integer n = listIterator.next();
//            if ( n%2 != 0)
//                listIterator.remove();
//            else
//                listIterator.add(n*2);
////---------------------------------------
//→ 0 0 2 4 4 8,
//        for (ListIterator<integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
//            Integer n = listIterator.next();
//            if ( n%2 != 0)
//                listIterator.set(n*2);
////---------------------------------------
//→ 0 2 2 6 4