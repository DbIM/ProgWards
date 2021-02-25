package ru.progwards.java1.lessons.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// В заданном каталоге и его подкаталогах найти файлы,
// точно совпадающие по названию (и расширению) getName(),
// дате-времени последнего изменения lastModified(),
// размеру и по содержимому length().
// Сигнатура метода public List<List<String>> findDuplicates(String startPath),
// результат - список, содержащий списки строк с именами и полными путями совпадающих файлов.

public class FindDuplicates {
    public static List<Path> fileList = new ArrayList<>();
    public static List<String> resultList = new ArrayList<>();

    static String checkFiles(String path) throws IOException {
        try {
            //создаем файловый массив размером с предылдущий массивный список
            File[] listFiles = new File[fileList.size()];
            //проходимся по всему массивному списку состоящему из одних только файлов
            for (int k = 0; k<fileList.size(); k++) {
                //заполняем файловый массив непосредственно файлами из найденных ранее совпадений
                listFiles[k] = fileList.get(k).toFile();
            }
            //проходимся по файловому массиву
            //до предпоследней позиции. последнюю проверит второй цикл
            for(int i1 = 0; i1 < listFiles.length-1; i1++){
                File file1 = listFiles[i1];
                //второй цикл
                for (int i2 = i1 + 1; i2 < listFiles.length; i2++){
                    File file2 = listFiles[i2];
                    //если размер полученных файлов не совпадает то и сверять дальше нечего
                    if (i2++ >= listFiles.length) break;
                    //в противном случае сверяем их имена, размеры и дату последнего изменения
                    if (file1.getName().equals(file2.getName())
                            && file1.length() == file2.length()
                            && file1.lastModified() == file2.lastModified()) {
                        //в случае полного совпадения добавляем полученные имена с полными путями
                        // в результируюий массивный список
                        String fileName1 = file1.toString();
                        String fileName2 = file2.toString();
                        resultList.add(fileName1);
                        resultList.add(fileName2);
                        System.out.println(file1 + " and " + "\n" + file2 + " are equals!");
                        System.out.println("file 1 length: " + file1.length() + "\nfile 2 length: " + file2.length());
                        System.out.println("file 1 lastModified: " + file1.lastModified() + "\nfile 2 lastModified: " + file2.lastModified());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Done!";
    }

    public static List<List<String>> findDuplicates(String startPath) throws IOException {
        //паттерн поиска файлов что-то точка расширение (если есть расширение, значит это НЕ каталог)
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/**.*");
        try {
            Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    if (pathMatcher.matches(path)) {
                        //добавляем все найденные совпадения (файлы) в предварительно созданный массивный список
                        fileList.add(path);
                    }
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        //вызываем функцию проверки всех найденных файлов
        checkFiles(startPath);
        //возвращаем итоговый результат
        return Collections.singletonList(resultList);
    }

    public static void main(String[] args) throws IOException {
        //FindDuplicates findDuplicates = new FindDuplicates();
        //findDuplicates.findDuplicates("C:\\Users\\rudnpro\\IdeaProjects\\Progwards\\src\\ru\\progwards\\java1\\lessons");
        System.out.println(findDuplicates("C:\\Users\\rudnpro\\IdeaProjects\\Progwards\\src\\ru\\progwards\\java1\\lessons"));
    }
}

