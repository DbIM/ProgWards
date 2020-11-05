package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;

    public Eratosthenes(int N) {
        this.sieve = new boolean[N];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift() {
        for (int n = 2; n < sieve.length; n++) {
            for (int i = 2; i < sieve.length - 1; i++) {
                if ((i + 1) % n == 0) {
                    sieve[i] = false;
                }
            }
        }
    }

    public boolean isSimple(int n){
        if (sieve[n] == true){
            return (true);
        }
        return (false);
    }

}
