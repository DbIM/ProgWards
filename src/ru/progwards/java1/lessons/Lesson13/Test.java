package ru.progwards.java1.lessons.Lesson13;

import java.util.*;

public class Test {
    //class User {
    //    public Integer id;
    //    public String name;
    //    User (Integer id, String name) {
    //        this.id = id;
    //        this.name = name;
    //    }
    //}
    //Создайте метод с сигнатурой public TreeSet<User> createSet()
    // который создает и возвращает TreeSet так,
    // что бы пользователи оказались упорядочены по убыванию id
    public TreeSet<User> createSet(){
        TreeSet<User> result = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.id, o1.id);
            }
        });
        return result;
    }


    //Реализуйте метод,с сигнатурой public Set<Integer> a2set(int[] a), который преобразует массив в множество
    public Set<Integer> a2set(int[] a){
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i<a.length; i++){
            result.add(a[i]);
        }
        return result;
    }

//Напишите метод с сигнатурой String figDetect(Figure fig), который
// - для квадрата возвращает "Сторона квадрата "+.side
//- для круга возвращает "Диаметр круга "+.diameter
//- для всех остальных классов "Неизвестная фигура"

    String figDetect(Figure fig){
        if (fig == null) return "Неизвестная фигура";
        if (fig.getClass() == Square.class) return "Сторона квадрата " + ((Square) fig).getSide();
        if (fig.getClass() == Round.class) return "Диаметр круга " + ((Round) fig).getDiameter();
        return "Неизвестная фигура";
    }


}
//	public static void iSetTest() {
//	       Set<Integer> iSet = new HashSet<>();
//	       for (int i = 0; i < 3; i++)
//		       for (int j = 0; j < 3; j++) {
//		    	   iSet.add(i+j);
//	       }
//	       System.out.println(iSet.size());
//	}
//5

//	   public static void wSetTest() {
//	       String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
//	       Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));
//
//	       Iterator<String> iter = wordSet.iterator();
//	       while (iter.hasNext())
//	           if (iter.next().contains("ра"))
//	               iter.remove();
//
//	       System.out.println(wordSet.size());
//	   }
//5

//    	public static void cset() {
//	       Set<Integer>  fiboSet1000 =
//	               Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
//	       int sum = 0;
//	       for (int i = 2; i < 10; i++)
//	           sum += fiboSet1000.contains(i) ? 1 : 0;
//	       System.out.println(sum);
//	   }
//4

//Правильные ответы:
// Содержит только уникальные элементы,
// Добавление элемента происходит чуть медленнее, чем в список,
// Поиск по ключу происходит значительно быстрее, чем в списке,
// Удаление элемента происходит быстрее, чем в списке

//Правильный ответ: Элементы упорядочены в порядке их добавления

//public void unionOfSets(final Set set1, final Set set2) {
//       HashSet result = new HashSet(set1);
//       result.addAll(set2);
//       System.out.println(result.size());
//}
//set1 = [1, 3, 5, 12, 45]
//set2 = [12, 44, 2, 1, 4]
//Правильный ответ: 8

//Правильные ответы:
// В множестве TreeSet элементы сортируются автоматически,
// Для сравнения элементов на уникальность в TreeSet используется compare или comareTo,
// Интерфейс NavigableSet дополняет SortedSet обратным итератором

//Правильный ответ: 985421

//Правильный ответ: 10121519
