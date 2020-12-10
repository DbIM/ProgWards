package ru.progwards.java1.lessons.Lesson10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NullPointerExceptionTest {
    public Integer sqr(Integer n) {
        try {
            return n * n;
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public String test(String filename) throws IOException {
        if (filename == null) {
            throw new IOException("File not found");
        }
        return "File processing";
    }

    private int lineCount(String filename) throws IOException {
        int quantity = 0;
        FileReader reader = null;
        try {
            reader = new FileReader(filename);
            try {
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine()) {
                    //именно этой строкой перебираем строки в файле
                    scanner.nextLine();
                    quantity++;
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new IOException("файл не найден");
        }
        return quantity;
    }


    public static void main(String[] args) throws IOException {
/*        FileWriter fileWriter = new FileWriter("file1.txt");
        fileWriter.write( "Этот файл создан мной.\n");
        fileWriter.write( "Теперь он будет жить на диске\n");
        fileWriter.write( "или на флешке\n");
        fileWriter.close();
        String filename = "src\\ru\\progwards\\java1\\lessons\\Lesson10\\text.txt";
        System.out.println(lineCount(filename));*/
    }
}


//Правильные ответы:
// Исключение - проблемы возникающие при выполнении кода,
// Исключения освобождают код от передачи информации о возникшей проблеме,
// Все исключения в Java описываются классами

//Правильные ответы:
// Проверяемые исключения - компилятор требует наличия try-catch или throws,
// Непроверяемые исключения - потомки RuntimeException,
// Пробросить проверяемое исключение можно через throws

//Правильный ответ:
//public static void test() throws IOException {
//    throw new IOException();
//}
//→ метод всегда выбрасывает IOException,
//try {
//    FileWriter writer = new FileWriter("aaaa", true);
//}
//catch (NullPointerException e) {
//
//}
//→ компилятор выдаст Unhandled exception: IOException,
//public static void test() throws IOException {
//    FileWriter writer = new FileWriter("aaaa", true);
//}
//→ метод может выбросить IOException

//Правильные ответы:
// Потоки предназначены для работы с вводом - выводом,
// Поток доставляет данные от источника к получателю,
// При работе с потоками нужно корректно обрабатывать исключения

//Правильный ответ:
// Символьная запись в файл → FileWriter,
// Символьное чтение из файла → FileReader,
// Бинарная запись в файл  → FileOutputStream,
// Бинарное чтение из файла  → FileInputStream

//Правильные ответы:
// Тип String неизменяемый (immutable) объект,
// Тип StringBuilder работает быстрее чем String при массовой конкатенации строк