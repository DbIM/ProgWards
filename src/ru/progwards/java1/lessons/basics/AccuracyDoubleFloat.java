package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static Double R = 6371.2;
    public static Double pi = 3.14;

    public static double volumeBallDouble(double radius) {
        return (4 * pi * (radius * radius * radius) / 3);
    }

    public static float volumeBallFloat(float radius) {
        return (float) (4 * pi * (radius * radius * radius) / 3);
    }

    public static double calculateAccuracy(double radius) {
        return (volumeBallDouble(radius) - volumeBallFloat((float) radius));
    }
}
