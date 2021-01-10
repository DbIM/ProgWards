package ru.progwards.java1.lessons.io2;
//2.1 Конструктор Translator(String[] inLang, String[] outLang),
// где inLang и outLang - массивы слов на разных языках,
// например русском и английском. Сохранить значения параметров в приватных свойствах класса
//
//2.2  Метод public String translate(String sentence),
// в котором найти слова, содержащиеся в sentence и в inLang
// и заменить их на соответствующие в outLang.
// Пунктуация должна быть соблюдена (скопирована из оригинальной строки).
// При этом надо соблюсти заглавные буквы, если они были в оригинальном тексте.
// В inLang и outLang все слова хранятся в нижнем регистре.

//repeat
//replaceAll

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Translator {
    //2.1 Конструктор Translator(String[] inLang, String[] outLang),
    // где inLang и outLang - массивы слов на разных языках,
    // например русском и английском.
    // Сохранить значения параметров в приватных свойствах класса
    //
    //2.2  Метод public String translate(String sentence),
    // в котором найти слова, содержащиеся в sentence и в inLang
    // и заменить их на соответствующие в outLang.
    // Пунктуация должна быть соблюдена (скопирована из оригинальной строки).
    // При этом надо соблюсти заглавные буквы, если они были в оригинальном тексте.
    // В inLang и outLang все слова хранятся в нижнем регистре.

    Translator(String[] inLang, String[] outLang){
    }

    public String translateWord(String word) {
        String result = word.toLowerCase();
        if (result == null) return word;
        if (Character.isUpperCase(word.charAt(0))) {
            return Character.toUpperCase(result.charAt(0)) + (result.length() > 1 ? result.substring(1) : "");
        }
        return result;
    }

    public String translate(String sentence) {
        StringBuilder result = new StringBuilder(128);
        int wordBeginIndex = -1;
        int len = sentence.length();

        for(int i = 0; i < len; i++) {
            char c = sentence.charAt(i);
            if (Character.isLetter(c)) {
                if (wordBeginIndex < 0) wordBeginIndex = i;
            } else {
                if (wordBeginIndex >= 0) {
                    result.append(translateWord(sentence.substring(wordBeginIndex, i)));
                    wordBeginIndex = -1;
                }
                result.append(c);
            }
        }
        if (wordBeginIndex >= 0) {
            result.append(translateWord(sentence.substring(wordBeginIndex)));
        }
        return result.toString();
    }
}
