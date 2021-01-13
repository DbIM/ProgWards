package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    //1.1 Метод public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) - объединение множеств
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
        HashSet result = new HashSet(set1);
        result.addAll(set2);
        return result;
    }

    //1.2 Метод public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) - пересечение множеств
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        HashSet result = new HashSet(set1);
        result.retainAll(set2);
        return result;
    }

    //1.3 Метод public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) - разница множеств
    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2){
        HashSet result = new HashSet(set1);
        result.remove(set2);
        return result;
    }

    //1.4 Метод public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) - симметрическая разница
    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2){
        HashSet intermedium1 = new HashSet(set1);
        HashSet intermedium2 = new HashSet(set2);
        intermedium1.remove(set2);
        intermedium2.remove(set1);
        HashSet result = new HashSet(intermedium1);
        result.addAll(intermedium2);
        return result;
    }
}
