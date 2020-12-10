package ru.progwards.java1.lessons.io1;

import javax.print.DocFlavor;
import java.io.*;

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
        FileReader fileIn = null;
        FileWriter fileOut = null;
        FileReader filterz = null;
        try {
            fileIn = new FileReader(inFileName);
            filterz = new FileReader(filter);
            fileOut = new FileWriter(outFileName);

            FileInputStream filterSize = new FileInputStream(filter);
            byte[] thisIsFilterSize = filterSize.readAllBytes();
            char[] charFilter = new char[thisIsFilterSize.length];

            FileInputStream fileInputSize = new FileInputStream(inFileName);
            byte[] thisIsFileInputSize = fileInputSize.readAllBytes();
            char[] charInputFile = new char[thisIsFileInputSize.length];

            for (int i = 0; i < thisIsFilterSize.length; i++) {
                charFilter[i] = (char) filterz.read();
            }
            for (int i2 = 0; i2 < thisIsFileInputSize.length; i2++){
                charInputFile[i2] = (char) fileIn.read();
            }

            for (int i = 0; i < charFilter.length; i++) {
                for (int i2 = 0; i2 < charInputFile.length; i2++){
                    if (charInputFile[i2] == charFilter[i]) {
                        charInputFile[i2] = 0;
                    }
                }
            }

            for (int i3=0; i3<charInputFile.length;i3++){
                fileOut.write(charInputFile[i3]);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
            if (fileOut != null) {
                fileOut.close();
            }
            if (filterz != null) {
                filterz.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "src\\ru\\progwards\\java1\\lessons\\io1\\file2.txt";
        String outFile = "src\\ru\\progwards\\java1\\lessons\\io1\\outFile.txt";
        String filter = "src\\ru\\progwards\\java1\\lessons\\io1\\filter.txt";
        filterFile(filename, outFile, filter);
    }
}
