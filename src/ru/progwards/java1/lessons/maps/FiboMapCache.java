package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;

public class FiboMapCache {
    //1.1 Определить приватную локальную переменную fiboCache как Map<Integer, BigDecimal>
    private HashMap<Integer, BigDecimal> fibocache = new HashMap<>();
    private boolean cacheOn;
    //1.2 Определить конструктор public FiboMapCache(boolean cacheOn) - включен ли кэш.
    public FiboMapCache(boolean cacheOn){
        this.cacheOn = cacheOn;
    }
    // При cacheOn = true кэш работает, при cacheOn = false - выключен
    //1.3 Реализовать public BigDecimal fiboNumber(int n). Алгоритм работы следующий:
    //в функции проверить, находится ли вычисленное значение для n в кэше,
    // и если да - вернуть его из кэша, если нет - рассчитать и добавить в кэш.
    // Учитывать значение переменной cacheOn
/*    public BigDecimal fiboNumber(int n){

    }*/
    //1.4 Реализовать метод public void clearCahe() который устанавливает переменную fiboCache в null
    //1.5 Для проверки работы реализовать public static void test() -
    // тест для расчета чисел Фибоначчи от n = 1 до 1000 включительно и замерить разницу во времени
    // с on = true и on = false, результат
    // вывести на экран в формате "fiboNumber cacheOn=??? время выполнения ???"
    // для cacheOn=true и cacheOn=false, вместо ??? вывести реальные значения в мсек.
}
