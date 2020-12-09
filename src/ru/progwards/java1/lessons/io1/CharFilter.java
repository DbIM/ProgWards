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
            byte[] newCode = new byte[filter.length()];
            for (int i = 0; i < filter.length(); i++) {
                newCode[i] = (byte) filter.charAt(i);
            }
            for (int i = 0; i < newCode.length; i++) {
                for (int i2 = 0; i < bytes.length; i2++) {
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
}
