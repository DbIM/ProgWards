package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food(int weight1) {
        weight = weight1;
    }

    @Override
    public double getWeight() {
        return weight;
    }


    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        if (weight < smthHasWeigt.getWeight()) {
            return CompareWeight.CompareResult.LESS;
        }
        if (weight == smthHasWeigt.getWeight()) {
            return CompareWeight.CompareResult.EQUAL;
        }
        return CompareWeight.CompareResult.GREATER;
    }

}
