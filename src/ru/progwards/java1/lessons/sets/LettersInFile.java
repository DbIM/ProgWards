package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LettersInFile {
    public static String process(String fileName) throws IOException {
        FileReader fileIn = new FileReader(fileName);
        Scanner scanner = new Scanner(fileIn);
        TreeSet<Character> treeSet = new TreeSet<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            str.toCharArray();
            char[] charArray = str.toCharArray();
            for (char aChar : charArray) {
                if (Character.isLetter(aChar)) treeSet.add(aChar);
            }
        }
        scanner.close();
        fileIn.close();

        List<Character> list = new ArrayList<>(treeSet);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Character aChar : list) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String filename = "src\\ru\\progwards\\java1\\lessons\\sets\\test.txt";
        System.out.println(process(filename));
    }
}
