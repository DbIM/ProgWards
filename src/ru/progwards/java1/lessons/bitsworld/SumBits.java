package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value) {
        int result = 0;
        int test;
        for (int i = 0; i < 8; i++) {
            test = value & 0x1;
            if (test == 1) {
                result++;
            }
            value >>= 1;
        }
        return result;
    }
}


