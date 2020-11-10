package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber){
        int[] result = new int[7];
        int test;
        for (int i = 0; i < 8; i++) {
            test = value & 0x1;
            if (test == 1) {
                result[i] = 1;
            }
            else result[i] = 0;
            value >>= 1;
        }
        return result[bitNumber];
    }
}
