package ru.progwards.java1.lessons.basics;

public class Astronomy {
    public static Double pi = 3.14;

    public static Double sphereSquare(Double r) {
        return (4 * pi * (r * r));
    }

    public static Double earthSquare() {
        Double earthRadius = 6371.2;
        return (sphereSquare(earthRadius));
    }

    public static Double mercurySquare() {
        Double mercuryRadius = 2439.7;
        return (sphereSquare(mercuryRadius));
    }

    public static Double jupiterSquare() {
        Double jupiterRadius = 71492.0;
        return (sphereSquare(jupiterRadius));
    }

    public static Double earthVsMercury() {
        return (earthSquare() / mercurySquare());
    }

    public static Double earthVsJupiter() {
        return (earthSquare() / jupiterSquare());
    }
}
