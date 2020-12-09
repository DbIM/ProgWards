package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
    // в котором посчитать количество пустых строк в файле. В случае возникновения ошибок, вернуть -1
    public static int calcEmpty(String fileName){
        int quantity = 0;
        int error = -1;
        String nothing = "";
        FileReader reader = null;
        try {
            reader = new FileReader(fileName);
            try {
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine()) {
                    String strFromFile = scanner.nextLine();
                    if (strFromFile.compareTo(nothing) == 0) quantity++;
                }
            } finally {
                reader.close();
            }
        }
        catch (FileNotFoundException e) {
            quantity = error;
        }
        catch (IOException e) {
            quantity = error;
        }
        return quantity;
    }


    public static void main(String[] args){
        String filename = "src\\ru\\progwards\\java1\\lessons\\io1\\file1111.txt";
        System.out.println(calcEmpty(filename));
    }
}
