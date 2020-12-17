package ru.progwards.java1.lessons.io2;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

public class PhoneNumber {
    // который форматирует телефон под формат +7(999)111-2233, входящий формат может быть различным:
    //формальное задание на форматирование:
    //- выделить все цифры, отбросить все разделители
    //- проверить что цифр в номере 11 или 10, в противном случае выбросить исключение
    //- убрать спереди 8
    //- добавить, если нужно +7
    //- отформатировать под выходной шаблон
    public static String format(String phone) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        //- выделить все цифры, отбросить все разделители
        for (char c : phone.toCharArray())
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            }
        //- проверить что цифр в номере 11 или 10, в противном случае выбросить исключение
        if (stringBuilder.length() < 10 || stringBuilder.length() > 11) {
            throw new IOException("недостаточно цифр в номере");
        }
        if (stringBuilder.length() == 10){
            stringBuilder.insert(0, '+');
            stringBuilder.insert(0, '+');
            stringBuilder.setCharAt(1, '7');
        }
        //- убрать спереди 8
        if (stringBuilder.charAt(0) == '8' || stringBuilder.length() == 10){
            stringBuilder.insert(0, '+');
            stringBuilder.setCharAt(1, '7');
        }
        //- добавить, если нужно +7
        if (stringBuilder.charAt(0) == '7'){
            stringBuilder.insert(0, '+');
        }
        stringBuilder.insert(2,'(');
        stringBuilder.insert(6,')');
        stringBuilder.insert(10,'-');
        return stringBuilder.toString();
    }


    public static void main(String[] args) throws IOException {
        System.out.println(format("+8911 928-51-26"));
    }
}
