package ru.progwards.java1.lessons.io1;

import java.io.*;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader fileIn = null;
        FileWriter fileOut = null;
        FileInputStream fileInputSize = null;

        try {
            fileIn = new FileReader(inFileName);
            fileOut = new FileWriter(outFileName);

            char[] charFilter = new char[filter.length()];
            for (int i = 0; i < charFilter.length; i++) {
                charFilter[i] = (char) filter.charAt(i);
            }

            fileInputSize = new FileInputStream(inFileName);
            byte[] thisIsFileInputSize = fileInputSize.readAllBytes();
            char[] charInputFile = new char[thisIsFileInputSize.length];
            for (int i = 0; i < thisIsFileInputSize.length; i++) {
                    charInputFile[i] = (char) fileIn.read();
                    if (charInputFile[i] == 65535) {
                        charInputFile[i] = 0;
                    }
            }

            for (int i = 0; i < charFilter.length; i++) {
                for (int i2 = 0; i2 < charInputFile.length; i2++) {
                    if (charInputFile[i2] == charFilter[i]) {
                        charInputFile[i2] = 0;
                    }
                }
            }

            for (int i3 = 0; i3 < charInputFile.length; i3++) {
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
            if (fileInputSize != null) {
                fileInputSize.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "src\\ru\\progwards\\java1\\lessons\\io1\\file2.txt";
        String outFile = "src\\ru\\progwards\\java1\\lessons\\io1\\outFile.txt";
        //String filter = "src\\ru\\progwards\\java1\\lessons\\io1\\filter.txt";
        String filter = "- —,.()";
        filterFile(filename, outFile, filter);
    }
}
