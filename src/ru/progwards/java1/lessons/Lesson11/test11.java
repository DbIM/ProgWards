package ru.progwards.java1.lessons.Lesson11;

import java.io.*;
import java.util.Scanner;
public class test11 {

    //правильный метод
/*
    public void test(int n) throws IOException {
        try {
            doSomething(n);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            throw new IOException();
        } finally {
            System.out.println("finally executed");
        }
    }
    */

    public void scanLines() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String keyboard = scanner.nextLine();
            if (keyboard.contains("Привет")) System.out.println("Здравствуйте!");
            else if (keyboard.contains("как дела")) System.out.println("Хорошо");
            else if (keyboard.contains("/stop")) break;
            else System.out.println(keyboard);
        }
    }

    static String invertWords(String sentence) {
        String[] words = sentence.split(" ");
        String backWords = "";
        for (int i = words.length - 1; i >= 0; i--) {
            backWords = backWords + words[i] + ".";
        }
        return backWords.substring(0, backWords.length() - 1);
    }

    //который читает файл filename и меняет в нем каждый 10-йбайт на символ *,
// при этом конкатенируя оригинальный символ в строку ответа.
    public static String setStars(String filename) throws IOException {
        String finalString = "";
        try (RandomAccessFile randomFile = new RandomAccessFile(filename, "rw")) {
            long totalByte = randomFile.length();
            for (int i = 9; i < totalByte; i += 10) {
                randomFile.seek(i);
                finalString = finalString + (char) randomFile.readUnsignedByte();
                randomFile.seek(i);
                randomFile.writeByte((int) '*');
            }
        } catch (IOException e) {
            throw new IOException(e.getClass().getName());
        }
        return finalString;
    }

    public static void main(String[] args) throws IOException {
        //System.out.println(invertWords("Буря мглою небо кроет"));
        String filename = "src\\ru\\progwards\\java1\\lessons\\Lesson11\\test111.txt";
        System.out.println(setStars(filename));

        String [] boolArray = new String[]{null, String.valueOf('a'), null, null};
        for (int i=0; i<boolArray.length; i++){
            if(boolArray[i]!=null){
                System.out.println(boolArray[i]);
            }
            else {
                System.out.println("null");
            }
        }
    }

}

//Правильные ответы:
// try-with-resources работает с классами, реализующими AutoClosable,
// Выбрасывание исключения достаточно ресурсоемкая операция,
// Существуют проверяемые и непроверяемые исключения

//Правильный ответ:
//doExceptions 1
//Exception in try (suppressed)
//Exception in finally
//→ неверный вариант,
//doExceptions 1
//Exception in finally
//Exception in try (suppressed)
//→ значение-параметра = 0,
//doExceptions 1
//doExceptions 2
//Exception in finally
//→ значение-параметра = 1

//Правильные ответы:
// Пакет java.io предоставляет возможности для работы с потоками, файлами и каталогами,
// Класс File позволяет: получать и изменять основную информацию о файле или каталоге,
// Класс File позволяет: создавать файлы, каталоги и цепочки каталогов,
// Класс Scanner позволяет обрабатывать ввод с клавиатуры и из файлов

//Правильные ответы:
// RandomAccessFile позволяет перемещаться по файлу побайтно в разные стороны с указанием позиции,
// RandomAccessFile позволяет читать, записывать (и перезаписывать) данные в текущую позицию,
// RandomAccessFile умеет читать и записывать строки

//Правильный ответ:
// Записать что-то побайтно → void write…(...),
// Переместить курсор к позиции → void seek(long pos),
// Считывает и возвращает байт (беззнаковое значение) → int read(),
// Прочитать массив байт в буфер bytes → int read(byte[] bytes),
// Возвращает текущую позицию курсора → long getFilePointer(),
// Прочитать строку → String readLine(),
// Считывает требуемое количество байт и возвращает указанный тип → read…()