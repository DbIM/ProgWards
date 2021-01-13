package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LettersInFile {
    public static String process(String fileName) throws IOException {
        FileReader fileIn = new FileReader(fileName);
        Scanner scanner = new Scanner(fileIn);
        String inFileString = "";
        while (scanner.hasNextLine()) {
            inFileString = inFileString + scanner.nextLine();
        }
        TreeSet<Character> result = new TreeSet<>();
        char[] wordSet = new char[inFileString.length()];
        for (int i = 0; i < inFileString.length(); i++) {
            if (Character.isLetter(inFileString.charAt(i))) {
                result.add(inFileString.charAt(i));
            }
        }
        int x = 0;
        for (char c : result) {
            wordSet[x] = c;
            x++;
        }
        Arrays.sort(wordSet);
        return String.valueOf(wordSet);
    }

    public static void main(String[] args) throws IOException {
        String filename = "src\\ru\\progwards\\java1\\lessons\\sets\\test.txt";
        System.out.println(process(filename));
    }
}
