package ru.progwards.java1.lessons.RAM;

//Создать класс RamCompiler, который принимает на вход исходный код на RAM и выполняет программу.
//
//Конструктор RamCompiler(String fileName)
//Метод execute() - выполняет программу
//Метод List<int> input() - возвращает входящий поток
//Метод List<int> output() - возвращает исходящий поток
//Метод List<int> registers() - регистры, номер регистра соответствует индексу в коллекции.
// Если какой-то регистр не был инициализирован, там должен быть null.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class RamCompiler {
    List<Integer> inputStream;
    List<Integer> outputStream;
    List<Integer> registers;

    void readRAM(int input){
        registers.add(inputStream.get(0), input);
        inputStream.remove(0);
    }

    void writeRAM(int input){
        outputStream.add(input, registers.get(0));
    }

    void loadRAM(int input){
        registers.add(0, input);
    }

    void storeRam(int input){
        registers.add(registers.get(input), registers.get(0));
    }


    RamCompiler(String fileName) throws FileNotFoundException {
        FileReader fileIn = new FileReader(fileName);
        Scanner scanner = new Scanner(fileIn);
        while (scanner.hasNextLine()) {
            String[] commands = scanner.nextLine().split(" ");
            for (int i = 0; i < commands.length; i++) {
                if (commands[i].equals("halt")) {
                    return;
                }
                if (commands[i].equals(";")) {
                    break;
                }
                if (commands[0].equals("<input>")) {
                    for (int i1 = 1; i1 < commands.length; i1++) {
                        inputStream.add(Integer.valueOf(commands[i]));
                    }
                }
                if (commands[0].equals("read")){
                    readRAM(Integer.parseInt(commands[1]));
                }

            }
        }
    }


}
