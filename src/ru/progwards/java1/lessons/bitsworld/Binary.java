package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;
    public Binary(byte num) {
        this.num = num;
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < 8; i++) {
            if ((num & 1) == 1) {
                str = 1 + str;
            }
            else {
                str = 0 + str;
            }
            num >>= 1;
        }
        return str;
    }
}
