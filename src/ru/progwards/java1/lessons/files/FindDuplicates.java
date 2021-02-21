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
            File[] listFiles = new File[fileList.size()];
            for (int k = 0; k<fileList.size(); k++) {
                listFiles[k] = fileList.get(k).toFile();
            }
            for(int i1 = 0; i1 < listFiles.length-1; i1++){
                File file1 = listFiles[i1];
                for (int i2 = i1 + 1; i2 < listFiles.length; i2++){
                    File file2 = listFiles[i2];
                    if (i2++ >= listFiles.length) break;
                    if (file1.getName().equals(file2.getName())
                            && file1.length() == file2.length()
                            && file1.lastModified() == file2.lastModified()) {
                        String fileName = file1.toString();
                        resultList.add(fileName);
                        System.out.println("File " + fileName + " equals!");
                        System.out.println("file 1 length: " + file1.length() + " file2 length: " + file2.length());
                        System.out.println("file 1 lastModified: " + file1.lastModified() + " file2 lastModified: " + file2.lastModified());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Done!";
    }

    public List<List<String>> findDuplicates(String startPath) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/**.*");
        try {
            Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    if (pathMatcher.matches(path)) {
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
        checkFiles(startPath);
        return Collections.singletonList(resultList);
    }

    public static void main(String[] args) throws IOException {
        FindDuplicates findDuplicates = new FindDuplicates();
        findDuplicates.findDuplicates("C:\\Users\\rudnpro\\IdeaProjects\\Progwards\\src\\ru\\progwards\\java1\\lessons");
    }
}

