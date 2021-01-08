package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {
    //найти 2 соседних числа в коллекции сумма которых минимальна,
    // вернуть коллекцию, содержащую индексы этих чисел
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers){
        if (numbers == null) return null;
        int index1 = 0;
        int index2 = 0;
        int sum;
        int sum2 = 0;

        for(Integer i : numbers) {
            for (Integer i2 : numbers) {
                sum = i + i2;
                if (sum2 > sum){
                   sum = i + i2;
                   index1 = i;
                   index2 = i2;
                }
                else {
                    sum2 = i + i2;
                    index1 = i;
                    index2 = i2;
                }
            }
        }
        Collection<Integer> result = new ArrayList<>();
        result.add(0, index1);
        result.add(1, index2);
        return result;
    }
}
