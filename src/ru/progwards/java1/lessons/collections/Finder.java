package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {
    //найти 2 соседних числа в коллекции сумма которых минимальна,
    // вернуть коллекцию, содержащую индексы этих чисел
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers){
        if (numbers == null) return null;

        int prev = 0;
        int index = 0;
        int sum;
        int minIndex = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (index > 0) {
                sum = num + prev;
                if (sum < minSum) {
                    minSum = sum;
                    minIndex = index;
                }
            }
            prev = num;
            index++;
        }

        Collection<Integer> result = new ArrayList<>();
        if (minIndex >= 1) result.add(minIndex - 1);
        if (minIndex >= 0) result.add(minIndex);
        return result;
    }
}
