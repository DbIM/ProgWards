package ru.progwards.java2.lessons.generics;

import ru.progwards.java1.lessons.interfaces.CompareWeight;

import java.util.ArrayList;
import java.util.List;

public class test {
    private static Object x;

    //Создайте статический метод с именем from,
    // который принимает параметром массив, обобщающего типа,
    // создает новый ArrayList,
    // копирует в него содержимое массива
    // и возвращает ArrayList в качестве результата метода.
    <B> ArrayList from(B[] massive){
        ArrayList<B> result = new ArrayList<>();
        for (int i = 0; i<massive.length; i++){
            result.add(massive[i]);
        }
        return result;
    }

    //Создайте статический метод с именем swap типа  void, который принимает параметром List,
    // обобщающего типа, и два int как индексы в списке.
    // Реализовать метод, который меняет элементы с указанными индексами местами.
    //Integer[] ai = {1,2,3,4,5};
    //List<Integer> li = from(ai);
    //swap(li,1,3);
    //System.out.println(li);
    //[1, 4, 3, 2, 5]
    static <T> void swap(List<T> inputList, int index1, int index2){
        T temp = inputList.get(index1);
        inputList.set(index1, inputList.get(index2));
        inputList.set(index2, temp);
    }

    //Определен enum CompareResult {LESS, EQUAL, GREATER};
    //Создайте статический метод с именем compare,
    // который содержит 2 параметра обобщающего типа,
    // и сравнивает их через метод compareTo.
    // Метод compare должен возвращать CompareResult, причем
    //CompareResult.LESS если первый параметр меньше второго
    //CompareResult.GREATER если первый параметр больше второго
    //CompareResult.EQUAL если первый параметр равен второму

    public static <T extends Comparable<T>> CompareWeight.CompareResult compare(T o1, T o2){
        if (o1.compareTo(o2) < 0){
            return CompareWeight.CompareResult.LESS;
        }
        else if (o1.compareTo(o2) > 0) {
            return CompareWeight.CompareResult.GREATER;
        }
        else {
            return CompareWeight.CompareResult.EQUAL;
        }
    }

    //    public static <T extends Comparable<T>> CompareResult compare(T o1, T o2){
    //        if (o1.compareTo(o2) < 0){
    //            return CompareResult.LESS;
    //        }
    //        else if (o1.compareTo(o2) > 0) {
    //            return CompareResult.GREATER;
    //        }
    //        else {
    //            return CompareResult.EQUAL;
    //        }
    //    }

/*    private static <T> Comparable<T> compare(Object x) {
    }*/

/*    public static void main(String[] args) {
        Integer[] ai = {1,2,3,4,5};
        List<Integer> li = from(ai);
        swap(li,1,3);
        System.out.println(li);
    }*/
}



//Правильные ответы:
// Нельзя генерировать или перехватывать экземпляры обобщенного класса в виде исключений,
// Параметрами не могут быть примитивные типы,
// Во время выполнения можно запросить только базовый тип или ограничение

//Правильный ответ: public class GTest<T> {
//	public void addAll(List<T> list, T... items) {
//		for (T item: items) {
//			list.add(item);
//		}
//	}
//}

//Правильные ответы:
// Обобщенными могут быть классы, интерфейсы, методы,
// Обобщения нужны для безопасного написания кода,
// Во время выполнения обобщенный тип стирается и заменяется на Object или на ограничивающий тип

//Правильный ответ: class GTest<T> {
//    public static <T extends Comparable<T>> GTest<T> from(List<T> list) {
//        GTest<T> result = new GTest<>();
//        //.. do something
//        return result;
//    }
//}

//Правильные ответы:
// Переменные типа в статическом контексте обобщенных классов недействительны,
// Можно использовать подстановочный тип для смягчения ограничений,
// При использовании обобщения отсутствует иерархия наследования


