package ru.progwards.java1.lessons.Lesson17;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lesson17 {
    //Создайте метод с сигнатурой String createFolder(String name),
    // который создает каталог name (один уровень) в текущей папке
    // и возвращает полный родителя текущего каталога
    static String createFolder(String name){
        new File(name).mkdir();
        Path path = Paths.get("..");
        return path.toAbsolutePath().normalize().toString();
    }

    //Реализовать метод с сигнатурой boolean replaceF(String name) который заменяет в файле все F на f,
    // в случае ошибки вернуть false. Для реализации пользоваться методами java.nio.file.Files.
    boolean replaceF(String name){
        String content, newContent;
        try {
            Path f = Paths.get(name);
            content = Files.readString(f);
            newContent = content.replaceAll("F", "f");
            Files.writeString(f, newContent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(createFolder("testicula"));


/*        Path path1 = Paths.get("C:\\Users\\rudnpro\\IdeaProjects\\Progwards\\src\\ru\\progwards\\java1\\lessons\\Lesson17");
        Path path2 = Paths.get("test17");
        System.out.println("Path1: " + path1);
        System.out.println("Path1 absolutepath: " + path1.toAbsolutePath());
        if (Files.exists(path1.toAbsolutePath())){
            System.out.println("Directory Exist!");
        }
        System.out.println("\nPath2: " + path2);
        System.out.println("Path2 absolutepath: " + path2.toAbsolutePath());
        if (!Files.exists(path2.toAbsolutePath())){
            System.out.println("No such directory!!!");
            }*/
    }
}



//Правильные ответы:
// Пакет java.nio умеет работать с абсолютными путями,
// Пакет java.nio умеет работать со специальными каталогами ".", "..",
// Пакет java.nio умеет находить относительный путь между двумя абсолютными

//Правильные ответы:
// Path createFile(Path path, FileAttribute<?>... attrs),
// void delete(Path path),
// boolean deleteIfExists(Path path),
// Path createDirectory(Path dir, FileAttribute<?>... attrs),
// Path createDirectories(Path dir, FileAttribute<?>... attrs),
// Path move(Path source, Path target, CopyOption... options),
// Path setAttribute(Path path, String attribute, Object value, LinkOption... options),
// Path setLastModifiedTime(Path path, FileTime time)

//Правильные ответы:
// Существует метод Files.walkFileTree для получения информации обо всех элементах дерева каталогов,
// При проходе по дереву каталогов можно указывать глубину,
// Для отбора нужных элементов применяется pathMatcher, понимающий glob

//Правильный ответ:
// Любое слово из перечисленных → {txt, bin, exe},
// Любой символ из перечисленных → [abc],
// Что угодно в рамках текущего каталога → *,
// Любой символ → ?,
// Что угодно в рамках текущего каталога и всех его подкаталогов → **

//Правильный ответ: 8