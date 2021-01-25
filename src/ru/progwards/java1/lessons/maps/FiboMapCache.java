package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private Map<Integer, BigDecimal> fiboCache;
    private boolean cacheOn;
    public FiboMapCache(boolean cacheOn){
        fiboCache = new HashMap<>();
        this.cacheOn = cacheOn;
    }
    public void clearCahe(){
        fiboCache.clear();
    }

    public BigDecimal fiboNumber(int n){
        BigDecimal result = BigDecimal.ZERO;
        if (cacheOn)
            if (fiboCache.containsKey(n))
                result = fiboCache.get(n);
            else {
                result = fibonacci(n);
                fiboCache.put(n, result);
            }
        else
            result = fibonacci(n);
        return result;
    }
    //  рассчет числа Фибоначчи для n
    static BigDecimal fibonacci(int n){
        BigDecimal f_n_2 = BigDecimal.ZERO;
        BigDecimal f_n_1 = BigDecimal.ONE;
        BigDecimal f_n = BigDecimal.ONE;
        for (int i = 2; i <= n; i++){
            f_n = f_n_2.add(f_n_1);
            f_n_2 = f_n_1;
            f_n_1 = f_n;
        }
        return f_n;
    }
    public static void test(){
        FiboMapCache test1 = new FiboMapCache(false);
        long start1 = System.currentTimeMillis();
        for (int i=1; i<=1000; i++)
            test1.fiboNumber(i);
        System.out.println("fiboNumber cacheOn = false время выполнения = " + (System.currentTimeMillis() - start1));

        FiboMapCache test2 = new FiboMapCache(true);
        long start2 = System.currentTimeMillis();
        for (int i=1; i<=1000; i++)
            test2.fiboNumber(i);
        System.out.println("fiboNumber cacheOn = true время выполнения = " + (System.currentTimeMillis() - start2));

    }
}
