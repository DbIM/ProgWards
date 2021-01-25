package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.currentTimeMillis;

public class FiboMapCache {
    private boolean cacheOn;

    FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
        clearCahe();
    }


    public void clearCahe() {
        if (cacheOn) {
            if (fiboCache != null) fiboCache.clear();
            fiboCache = new HashMap<Integer, BigDecimal>();
            fiboCache.put(1, BigDecimal.ONE);
            fiboCache.put(2, BigDecimal.ONE);
            lastFiboCache_n = 2;
            lastFibo_f1 = BigDecimal.ZERO;
            lastFibo_f2 = BigDecimal.ONE;
            lastFibo_n = 1;
        }
    }


    public BigDecimal fiboNumber(int n) {
        return cacheOn ? fiboCacheMap(n) : fiboNoCache(n);
    }



    Map<Integer, BigDecimal> fiboCache;
    int lastFiboCache_n;

    public BigDecimal fiboCacheMap(int n) {

        if (fiboCache.containsKey(n)) return fiboCache.get(n);

        BigDecimal f1 = fiboCache.get(lastFiboCache_n - 1);
        BigDecimal f2 = fiboCache.get(lastFiboCache_n);
        BigDecimal t;
        int i = lastFiboCache_n;

        while (i++ < n) {
            t = f2;
            f2 = f2.add(f1);
            f1 = t;
            fiboCache.put(i, f2);
            if (i % 3 == 0)
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                }
        }

        lastFiboCache_n = n;
        return f2;
    }


    int lastFibo_n = 1;
    BigDecimal lastFibo_f1 = BigDecimal.ZERO;
    BigDecimal lastFibo_f2 = BigDecimal.ONE;

    public BigDecimal fiboCacheLast(int n) {

        if (lastFibo_n == n) return lastFibo_f2;

        BigDecimal f1;
        BigDecimal f2;
        BigDecimal t;
        int i;

        if (lastFibo_n < n) { // используем кеш
            f1 = lastFibo_f1;
            f2 = lastFibo_f2;
            i = lastFibo_n;
        } else { // считаем сначала
            f1 = BigDecimal.ZERO;
            f2 = BigDecimal.ONE;
            i = 1;
        }

        while (i++ < n) {
            t = f2;
            f2 = f2.add(f1);
            f1 = t;
        }

        lastFibo_n = n;
        lastFibo_f1 = f1;
        lastFibo_f2 = f2;
        return f2;
    }


    public BigDecimal fiboNoCache(int n) {
        try { Thread.sleep(1);
        } catch (InterruptedException ex) {
        }
        BigDecimal f1 = BigDecimal.ZERO;
        BigDecimal f2 = BigDecimal.ONE;
        BigDecimal t;
        int i = 1;
        while (i++ < n) {
            t = f2;
            f2 = f2.add(f1);
            f1 = t;
        }
        return f2;
    }

    public static void test() {
        long start;
        FiboMapCache f;

        start = currentTimeMillis();
        f = new FiboMapCache(false);
        for (int i = 1; i <= 1000; i++) f.fiboNumber(i);
        System.out.println("fiboNumber cacheOn=" + false + " время выполнения " + (currentTimeMillis() - start));

        start = currentTimeMillis();
        f = new FiboMapCache(true);
        for (int i = 1; i <= 1000; i++) f.fiboNumber(i);
        System.out.println("fiboNumber cacheOn=" + true + " время выполнения " + (currentTimeMillis() - start));

    }
}
