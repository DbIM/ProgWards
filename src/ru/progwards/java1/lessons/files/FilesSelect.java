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

        String pattern = "glob:**/*.txt";
        for (String key : keys) {
            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(pattern);
            try {
                Files.walkFileTree(Paths.get(inFolder), new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                        if (pathMatcher.matches(path)) {
                            try {
                                File file = path.toFile();
                                FileReader fr = new FileReader(file);
                                BufferedReader reader = new BufferedReader(fr);
                                String line = reader.readLine();
                                while (line != null) {
                                    if (line.equals(key)) {
                                        File matchedFile = path.getFileName().toFile();
                                        String newDirFromFileName = matchedFile.toString().replaceAll(".txt", "");
                                        //String newDirCreate = outFolder + "\\" + newDirFromFileName;
                                        String newDirCreate = newDirFromFileName;
                                        Files.createDirectories(Paths.get(newDirCreate));
                                        Path srcFile = path.toAbsolutePath();
                                        Path destFile = Paths.get(newDirCreate).resolve(matchedFile.toString());
                                        Files.copy(srcFile, destFile, StandardCopyOption.REPLACE_EXISTING);
                                        System.out.println("File copied");
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
        List<String> keys = Arrays.asList("aaa", "bbb");
        FilesSelect filesSelect = new FilesSelect();
        filesSelect.selectFiles(inFolder, outFolder, keys);
    }
}
