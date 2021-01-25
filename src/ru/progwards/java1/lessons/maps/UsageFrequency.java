package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsageFrequency {
    static Map<Character, Integer> letters;
    static Map<String, Integer> words;

    public static void processFile(String fileName) throws IOException {
        letters = new HashMap<Character, Integer>(500);
        words = new HashMap<String, Integer>(5000);
        FileReader fileIn = new FileReader(fileName);
        try {
            Scanner scanner = new Scanner(fileIn);
            while (scanner.hasNextLine()) {
                solve(scanner.nextLine());
            }
        } finally {
            fileIn.close();
        }
    }

    private static void solve(String nextLine) {
        int wordBeginIdx = -1;
        Character keyChar;
        String keyWord;
        int strLen = nextLine.length();
        for (int i = 0; i < strLen; i++) {
            keyChar = nextLine.charAt(i);
            if (Character.isLetterOrDigit(keyChar)) {
                letters.put(keyChar, letters.containsKey(keyChar) ? 1 + letters.get(keyChar) : 1);
                if (wordBeginIdx < 0) wordBeginIdx = i;
            } else {
                if (wordBeginIdx >= 0) {
                    keyWord = nextLine.substring(wordBeginIdx, i);
                    words.put(keyWord, words.containsKey(keyWord) ? 1 + words.get(keyWord) : 1);
                    wordBeginIdx = -1;
                }
            }
        }
        if (wordBeginIdx >= 0) {
            keyWord = nextLine.substring(wordBeginIdx, strLen);
            words.put(keyWord, words.containsKey(keyWord) ? 1 + words.get(keyWord) : 1);
        }
    }


    public static Map<Character, Integer> getLetters() {
        return letters;
    }


    public static Map<String, Integer> getWords() {
        return words;
    }

    public static void main(String[] args) throws IOException {
        String filename = "src\\ru\\progwards\\java1\\lessons\\maps\\wiki.train.tokens";
        processFile(filename);
        System.out.println(getLetters());
        System.out.println(getWords());
    }
}
