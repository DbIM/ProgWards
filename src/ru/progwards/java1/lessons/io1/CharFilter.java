package ru.progwards.java1.lessons.io1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CharFilter {
    //прочитать файл inFileName и удалить символы, содержащиеся в String filter,
    // результат записать в выходной файл.
    // В случае возникновения ошибки, пробросить стандартное исключение выше, корректно закрыв все ресурсы
    //
    //Например файл содержит:
    //Java — строго типизированный объектно-ориентированный язык программирования,
    // разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
    //obscene = " -,.()"
    //Должен выдать результат:
    //JavaстроготипизированныйобъектноориентированныйязыкпрограммированияразработанныйкомпаниейSunMicrosystemsвпоследующемприобретённойкомпаниейOracle

    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;
        try {
            fileIn = new FileInputStream(inFileName);
            fileOut = new FileOutputStream(outFileName);
            byte[] bytes = fileIn.readAllBytes();
            FileInputStream filterz = new FileInputStream(filter);
            byte[] newCode = filterz.readAllBytes();
            for (int i = 0; i < newCode.length; i++) {
                for (int i2 = 0; i2 < bytes.length; i2++) {
                    if (bytes[i2] == newCode[i]) {
                        bytes[i2] = 0;
                    }
                }
            }
            fileOut.write(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileIn.close();
            fileOut.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "src\\ru\\progwards\\java1\\lessons\\io1\\file2.txt";
        String outFile = "src\\ru\\progwards\\java1\\lessons\\io1\\outFile.txt";
        String filter = "src\\ru\\progwards\\java1\\lessons\\io1\\filter.txt";
        filterFile(filename, outFile, filter);
    }
}
