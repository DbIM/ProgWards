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

   private Translator(String[] inLang, String[] outLang){
    }

    public String translate(String sentence) throws FileNotFoundException {
        FileReader reader = new FileReader(sentence);
        Scanner scanner = new Scanner(reader);
        String str = "";
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
        }
        String[] sentenceFile = str.split(" ");
        for (int i = 0; i<sentenceFile.length; i++){

        }
        return null;
    }
}
