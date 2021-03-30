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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RamCompiler {
    List<Integer> inputStream = new ArrayList<Integer>();
    List<Integer> outputStream = new ArrayList<Integer>();
    List<Integer> registers = new ArrayList<Integer>();

    ArrayList<String> list = new ArrayList<String>();

    void readRAM(int input, int counter) {
        if (input == 0) {
            registers.remove(0);
        }
        registers.add(input, inputStream.get(counter));
    }

    void writeRAM(int input) {
        outputStream.add(registers.get(input));
    }

    void loadRAMeq(int input) {
        registers.remove(0);
        registers.add(0, input);
    }

    void loadRAM(int input) {
        int temp = registers.get(input);
        registers.remove(0);
        registers.add(0, temp);
    }

    void storeRAM(int input) {
        int temp = registers.get(0);
        registers.remove(input);
        registers.add(input, temp);
    }

    void addRAM(int input) {
        int x = registers.get(0);
        int y = x + registers.get(input);
        registers.remove(0);
        registers.add(0, y);
    }

    void addRAMeq(int input) {
        int x = registers.get(0);
        int y = x + input;
        registers.remove(0);
        registers.add(0, y);
    }

    void subRAMeq(int input) {
        int x = registers.get(0);
        int y = x - input;
        registers.remove(0);
        registers.add(0, y);
    }

    void subRAM(int input) {
        int x = registers.get(0);
        int y = x - inputStream.get(input);
        registers.remove(0);
        registers.add(0, y);
    }

    int delPoint(String input) {
        String resultString = "";
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (input.toCharArray()[i] != '*') {
                resultString = resultString + input.toCharArray()[i];
            }
        }
        int result = Integer.parseInt(resultString);
        return result;
    }

    int delEqual(String input) {
        String resultString = "";
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (input.toCharArray()[i] != '=') {
                resultString = resultString + input.toCharArray()[i];
            }
        }
        int result = Integer.parseInt(resultString);
        return result;
    }

    int loop(String input, int stringCount){
        int stringNum = stringCount;

        return stringNum;
    }

    RamCompiler(String fileName) throws FileNotFoundException {
        for (int reg = 0; reg < 3; reg++) {
            registers.add(null);
        }
        registers.add(0, 0);
        FileReader fileIn = new FileReader(fileName);
        Scanner scanner = new Scanner(fileIn);
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
    }

    List<Integer> input() {
        return inputStream;
    }

    List<Integer> output() {
        return outputStream;
    }

    List<Integer> registers() {
        return registers;
    }

    void execute(){
            int labelIndex = 1;
            int inputStreamCounter = 0;
            for (int c = 0; c < list.size(); c++) {
                String[] commands = list.get(c).toString().split(" ");
                for (int i = 0; i < commands.length; i++) {
                    if (commands[i].toLowerCase().equals("halt")) {
                        return;
                    }
                    else if (commands[i].equals(";")) {
                        break;
                    }
                    if (commands[i].contains(":")) {
                        labelIndex = c;
                        break;
                    }
                    if (commands[i].toLowerCase().equals("jmp")) {
                        c = labelIndex;
                        break;
                    }
                    if (commands[i].toLowerCase().equals("jgtz")) {
                        if (registers.get(0) > 0) {
                            c = labelIndex;
                            break;
                        }
                    }
                    if (commands[i].toLowerCase().equals("jz")) {
                        if (registers.get(0) == 0) {
                            c = labelIndex;
                            break;
                        }
                    }
                    if (commands[0].toLowerCase().contains("<input>")) {
                        for (int i1 = 1; i1 < commands.length; i1++) {
                            inputStream.add(Integer.parseInt(commands[i1]));
                        }
                        break;
                    }
                    if (commands[i].toLowerCase().contains("read")) {
                        int x = i + 1;
                        if (commands[x].contains("*")){
                            int input = delPoint(commands[x]);
                            readRAM(input, inputStreamCounter);
                        }
                        else {
                            readRAM(Integer.parseInt(commands[x]), inputStreamCounter);
                        }
                        inputStreamCounter++;
                        break;
                    }
                    if (commands[i].toLowerCase().contains("write")) {
                        int x = i + 1;
                        writeRAM(Integer.parseInt(commands[x]));
                        break;
                    }
                    if (commands[i].toLowerCase().contains("load")) {
                        int x = i + 1;
                        if (commands[x].contains("=")) {
                            int input = delEqual(commands[x]);
                            loadRAMeq(input);
                            break;
                        } else {
                            loadRAM(Integer.parseInt(commands[x]));
                            break;
                        }
                    }
                    if (commands[i].toLowerCase().contains("store")) {
                        int x = i + 1;
                        storeRAM(Integer.parseInt(commands[x]));
                        break;
                    }
                    if (commands[i].toLowerCase().contains("add")) {
                        int x = i + 1;
                        if (commands[x].contains("=")){
                            int input = delEqual(commands[x]);
                            addRAMeq(input);
                            break;
                        }
                        else {
                            addRAM(Integer.parseInt(commands[x]));
                            break;
                        }
                    }
                    if (commands[i].toLowerCase().contains("sub")) {
                        int x = i + 1;
                        if (commands[x].contains("=")) {
                            int input = delEqual(commands[x]);
                            subRAMeq(input);
                            break;
                        } else {
                            subRAM(Integer.parseInt(commands[x]));
                            break;
                        }
                    }
                }
            }
        }

    public static void main(String[] args) throws FileNotFoundException {
/*        String filename = "src\\ru\\progwards\\java1\\lessons\\RAM\\ramtest.txt";
        String filename2 = "src\\ru\\progwards\\java1\\lessons\\RAM\\ramtest2.txt";*/
        String filename3 = "src\\ru\\progwards\\java1\\lessons\\RAM\\sort.ram";
/*        RamCompiler ramCompiler = new RamCompiler(filename);
        RamCompiler ramCompiler2 = new RamCompiler(filename2);*/
        RamCompiler ramCompiler3 = new RamCompiler(filename3);
/*        ramCompiler.execute();
        ramCompiler2.execute();*/
        ramCompiler3.execute();
/*        System.out.println("Входящая лента: " + ramCompiler.input());
        System.out.println("Задействованные регистры: " + ramCompiler.registers());
        System.out.println("Выходной поток: " + ramCompiler.output() + "\n");

        System.out.println("Входящая лента 2: " + ramCompiler2.input());
        System.out.println("Задействованные регистры 2: " + ramCompiler2.registers());
        System.out.println("Выходной поток 2: " + ramCompiler2.output());*/

        System.out.println("Входящая лента 3: " + ramCompiler3.input());
        System.out.println("Задействованные регистры 3: " + ramCompiler3.registers());
        System.out.println("Выходной поток 3: " + ramCompiler3.output());
    }
}

