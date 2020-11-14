package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    static CacheInfo lastFibo = new CacheInfo();;

    public static int fiboNumber(int n) {
        if (n == CalculateFibonacci.lastFibo.n) {
            return CalculateFibonacci.lastFibo.fibo;
        }
        int z = 0;
        int i = 1;
        int k = 0;
        int tryNum = 0;
        while (tryNum != n) {
            i = i + z;
            tryNum += 1;
            z = k;
            k = i;
        }
        CalculateFibonacci.lastFibo.n = n;
        CalculateFibonacci.lastFibo.fibo = i;
        return i;
    }

    private static class CacheInfo {
        public int n;
        public int fibo;
    }

    public static CacheInfo getLastFibo(){
        return lastFibo;
    }

    public static void clearLastFibo(){
        lastFibo = null;
    }
}
