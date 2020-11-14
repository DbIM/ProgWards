package ru.progwards.java1.lessons.interfaces;


public class CalculateFibonacci {

    private static CacheInfo lastFibo = new CacheInfo();

    public static int fiboNumber(int n) {
        lastFibo = new CacheInfo();
        if (CacheInfo.n == n) {
            return CacheInfo.fibo;
        }
        int a = 1;
        int b = 0;
        for (int i = 0; i < n; i++) {
            CacheInfo.fibo = a + b;
            a = b;
            b = CacheInfo.fibo;
        }
        System.out.println(CacheInfo.fibo);
        CacheInfo.n = n;
        return CacheInfo.fibo;
    }


    public static class CacheInfo {
        public static int n;
        public static int fibo;
    }

    public static CacheInfo getLastFibo() {
        return lastFibo;
    }


    public static void clearLastFibo() {  //☺
        lastFibo = null;
    }
}