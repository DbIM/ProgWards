package ru.progwards.java1.lessons.interfaces;

public class Food {
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }

    public CompareWeight.CompareResult compareWeight(Double weight){
        if(this.weight < weight){
            return CompareWeight.CompareResult.LESS;
        }
        if(this.weight == weight){
            return CompareWeight.CompareResult.EQUAL;
        }
        return CompareWeight.CompareResult.GREATER;
    }

    public static void sort(CompareWeight[] a){
        int x;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
    }

}
