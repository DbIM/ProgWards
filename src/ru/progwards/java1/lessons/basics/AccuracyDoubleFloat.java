package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static Double R = 6371.2;
    public static Double pi = 3.14;

    public static double volumeBallDouble(double radius) {
        return (4 / (3 * pi * (radius * radius * radius)));
    }

    public static float volumeBallFloat(float radius) {
        return (float) (4 / (3 * pi * (radius * radius * radius)));
    }

    public static double calculateAccuracy(double radius) {
        return (volumeBallDouble(radius) - volumeBallFloat((float) radius));
    }

}
