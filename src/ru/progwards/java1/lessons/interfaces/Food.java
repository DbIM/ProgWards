package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }


    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        if (this.weight < smthHasWeigt.getWeight()) {
            return CompareWeight.CompareResult.LESS;
        }
        if (this.weight == smthHasWeigt.getWeight()) {
            return CompareWeight.CompareResult.EQUAL;
        }
        return CompareWeight.CompareResult.GREATER;
    }


    public static void sort(Comparable<Animal>[] a) {
        Comparable x;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareTo((Animal) a[j]) > 0) {
                    x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
    }

}
