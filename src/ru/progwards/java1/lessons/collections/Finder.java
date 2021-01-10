package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Finder {
    //найти 2 соседних числа в коллекции сумма которых минимальна,
    // вернуть коллекцию, содержащую индексы этих чисел
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        if (numbers == null) return null;

        ArrayList<Integer> middle = new ArrayList(numbers);
        int index1 = middle.indexOf(middle.get(0));
        int index2 = middle.indexOf(middle.get(1));
        int num1 = middle.get(0);
        int num2 = middle.get(1);
        int sum2 = num1 + num2;
        for (int i = 0 ; i < middle.size() - 1; i++) {
            int sum = middle.get(i) + middle.get(i + 1);
            if (sum < sum2) {
                index1 = middle.indexOf(middle.get(i));
                index2 = middle.indexOf(middle.get(i + 1));
                sum2 = sum;
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
        for (int i = 1; i < middle.size() - 1; i++) {
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
        String testName = middle.get(0);
        String testName2 = "";
        int x = 0;
        int x2 = 0;
        for (int i = 1; i < middle.size(); i++) {
            if (testName.equals(middle.get(i))) {
                x++;
                testName2 = testName;
            }
            else {
                testName = middle.get(i);
            }
        }
        return testName + ": " + x;
    }

    public static void main(String[] args) {
        Collection<String> s = new ArrayList<>();
        s.add("Борис");
        s.add("Борис");
        s.add("Василий");
        s.add("Александр");
        s.add("Александр");
        s.add("Василий");
        s.add("Василий");
        s.add("Борис");
        s.add("Дмитрий");
        s.add("Борис");
        s.add("Борис");
        s.add("Григорий");
        System.out.println(findSimilar(s));
    }
}
