package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) throws IOException {
        int quantity = 0;
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
        } catch (IOException e) {
            throw new IOException("-1");
        }
        return quantity;
    }
}
