package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.Scanner;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader fileIn = null;
        FileWriter fileOut = null;

        try {
            fileIn = new FileReader(inFileName);
            fileOut = new FileWriter(outFileName);

            char[] charFilter = new char[filter.length()];
            for (int i = 0; i < charFilter.length; i++) {
                charFilter[i] = filter.charAt(i);
            }

            Scanner scanner = new Scanner(fileIn);
            String inFileString = "";
            while (scanner.hasNextLine()){
                inFileString = scanner.nextLine();
            }
            char[] charInputFile = new char[inFileString.length()];
            for (int i = 0; i < charInputFile.length; i++) {
                    charInputFile[i] = inFileString.charAt(i);
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
