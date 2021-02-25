package ru.progwards.java1.lessons.files;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

import static ru.progwards.java1.lessons.files.FindDuplicates.fileList;
// Реализовать метод с сигнатурой public void selectFiles(String inFolder, String outFolder, List<String> keys),
// который сортирует файлы по их содержимому.
// Нужно просмотреть содержимое всех файлов, с расширением txt,
// содержащихся в каталоге inFolder с подкаталогами,
// и если файл содержит ключевое слово из коллекции keys,
// то скопировать его в подпапку с соответствующим именем,
// этого элемента keys, все подпапки должны находиться в outFolder.

//Например, вызвана функция с параметрами (“aaa”, “bbb”, {“check”, “files”} )
//нужно проверить каталог aaa с подкаталогами,
// найти там все файлы txt, и если файл содержит “check”,
// скопировать его в папку bbb/check, если файл содержит “files”,
// скопировать его в папку bbb/files.
// Важно! Если, например, слово “files” ни разу не встретилось, пустую папку создавать не нужно

public class FilesSelect {
    public void selectFiles(String inFolder, String outFolder, List<String> keys) {
        String pattern = "glob:**/*.txt"; //проверяем только текстовые файлы
        for (String key : keys ) { //проверяем каждый "ключ"
            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(pattern);
            try {
                Files.walkFileTree(Paths.get(inFolder), new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                        if (pathMatcher.matches(path)) { //если файл текстовый то...
                            try {
                                File file = path.toFile();
                                FileReader fr = new FileReader(file);
                                BufferedReader reader = new BufferedReader(fr);
                                String line = reader.readLine(); //читаем его построчно
                                while (line != null) {
                                    if (line.contains(key)) { //если файл содержит "ключевую" строку
                                        File matchedFile = path.getFileName().toFile();
                                        String newDirCreate = outFolder + "\\" + key;
                                        Files.createDirectories(Paths.get(newDirCreate));
                                        System.out.println("Folder created."); //создаем папку для совпадения
                                        Path srcFile = path.toAbsolutePath();
                                        Path destFile = Paths.get(newDirCreate).resolve(matchedFile.toString());
                                        Files.copy(srcFile, destFile, StandardCopyOption.REPLACE_EXISTING);
                                        System.out.println("File copied."); // копируем в созданную папку подходящий файл
                                    }
                                    line = reader.readLine();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
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
        }
    }

    public static void main(String[] args) {
        String inFolder = "C:\\Users\\rudnpro\\IdeaProjects\\Progwards\\src\\ru\\progwards\\java1\\lessons\\Lesson17";
        String outFolder = "C:\\Users\\rudnpro\\IdeaProjects\\Progwards\\src\\ru\\progwards\\java1\\lessons\\Lesson17\\temp";
        List<String> keys = Arrays.asList("111", "222", "333", "123");
        FilesSelect filesSelect = new FilesSelect();
        filesSelect.selectFiles(inFolder, outFolder, keys);
    }
}
