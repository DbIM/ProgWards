package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight {
    double getWeight();
    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    public enum CompareResult {
        LESS,EQUAL,GREATER
    };
}
