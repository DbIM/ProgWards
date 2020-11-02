package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static void main(String[] args) {
        System.out.println(reverseDigits(123));
        System.out.println(reverseDigits(456));
        System.out.println(reverseDigits(789));
    }

    public static int reverseDigits(int number){
        StringBuilder sb = new StringBuilder(Integer.toString(number));
        StringBuilder reversedString = sb.reverse();
        int reversedNumber = Integer.parseInt(String.valueOf(reversedString));
        return (reversedNumber);
    }
}
