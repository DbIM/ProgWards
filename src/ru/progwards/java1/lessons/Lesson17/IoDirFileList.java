package ru.progwards.java1.lessons.Lesson17;

import java.io.File;

public class IoDirFileList {
    public static void main(String args[]) {
        // задаём целевой каталог
        File dir = new File("C:\\Users\\rudnpro\\IdeaProjects\\Progwards\\src\\ru\\progwards\\java1\\lessons\\Lesson17\\");
        // получаем список файлов и каталогов
        File[] listFiles = dir.listFiles();
        for (File f : listFiles) {
            System. out.println(
                    String. format("%-17s", f.getName()) +
                            (f.isHidden() ? "скрытый " : "") +
                            (f.isDirectory() ? "каталог" : f.length() + " байт")
            );
        }
    }
}
