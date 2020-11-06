package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {

    //1.1 Реализовать класс Eratosthenes, содержащий:
    //массив boolean, индексы которого являются числами, собственно, "решето"
    //private boolean[] sieve, для того, чтобы узнать,
    // является ли число n простым, нужно взять значение по индексу в массиве.
    // sieve[n]. Значение true, означает простое число, false - составное.
    private boolean[] sieve;

    //Реализовать конструктор
    //public Eratosthenes(int N),
    // который должен разместить массив sieve с размером в N и заполнить его значениями true,
    // после чего вызвать метод sift()
    public Eratosthenes(int N) {
        this.sieve = new boolean[N];
        Arrays.fill(sieve, true);
        sift();
    }

    //Реализовать метод
    //private void sift(), который, собственно и реализует алгоритм Эратосфена, просеивая составные числа.
    //Подсказка - нужно реализовать 2 вложенных цикла, внешний, например по i от 2 до N-1,
    // и внутренний, например по j который будет просеивать числа,
    // кратные переменной внешнего цикла i*j.
    private void sift() {
        for (int p = 2; p * p <= sieve.length - 1; p++) {
            if (sieve[p] == true) {
                for (int i = p * 2; i <= sieve.length - 1; i += p)
                    sieve[i] = false;
            }
        }
    }


    //Реализовать метод
    //public boolean isSimple(int n), который возвращает sieve[n],
    // что бы можно было узнать, простое число n или составное
    public boolean isSimple(int n) {
        return sieve[n];
    }

}
