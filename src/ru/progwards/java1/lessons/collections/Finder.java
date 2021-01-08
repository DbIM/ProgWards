package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {
    //найти 2 соседних числа в коллекции сумма которых минимальна,
    // вернуть коллекцию, содержащую индексы этих чисел
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        if (numbers == null) return null;
        int index1 = 0;
        int index2 = 0;
        int sum;
        int sum2 = 0;

        ArrayList<Integer> middle = new ArrayList(numbers);
        for (int i = 0; i < middle.size(); i++) {
            sum = middle.get(i) + middle.get(i + 1);
            if (sum2 > sum) {
                index1 = middle.get(i);
                index2 = middle.get(i + 1);
            } else {
                sum2 = middle.get(i) + middle.get(i + 1);
                index1 = middle.get(i);
                index2 = middle.get(i + 1);
            }
        }
        Collection<Integer> result = new ArrayList();
        result.add(index1);
        result.add(index2);
        return result;
    }


    //найти локальные максимумы - числа, которые больше соседа справа и слева.
// Первый и последний элемент коллекции не может являться локальным  максимумом,
// вернуть коллекцию, содержащую значения этих максимумов
    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        if (numbers == null) return null;
        int prev;
        int next;
        ArrayList<Integer> middle = new ArrayList(numbers);
        Collection<Integer> result = new ArrayList();
        for (int i = 1; i < middle.size(); i++) {
            prev = middle.get(i - 1);
            next = middle.get(i + 1);
            if (middle.get(i) > prev && middle.get(i) > next) {
                result.add(middle.get(i));
            }
        }
        return result;
    }

    //проверить, содержит ли коллекция все числа от 1 до size(), порядок может быть произвольный
    public static boolean findSequence(Collection<Integer> numbers) {
        int x = 0;
        for (Integer i : numbers) {
            x++;
        }
        if (x != numbers.size()) {
            return false;
        } else {
            return true;
        }
    }

    //найдите максимальное количество повторяющихся подряд элементов.
// Результат вернуть в виде строки <элемент>:<количество>,
// например Василий:5. При равенстве максимального количества у разных повторяющихся элементов,
// вернуть результат для элемента, повторяющаяся последовательность которого началась с наименьшего индекса.
    public static String findSimilar(Collection<String> names) {
        ArrayList<String> middle = new ArrayList(names);
        middle.sort(null);
        String testName = "";
        String testName2 = "";
        int x = 0;
        int x2 = 0;
        for (int i = 0; i< middle.size(); i++){
            for ( int i2 = 1; i2< middle.size(); i2++){
                if (testName2.equals(middle.get(i2))) {
                    x2++;
                }
                if (middle.get(i2).equals(middle.get(i))) {
                    testName = middle.get(i);
                    x++;
                }
                testName2 = middle.get(i2);
            }
        }
        return testName + ": " + x;
    }
}
