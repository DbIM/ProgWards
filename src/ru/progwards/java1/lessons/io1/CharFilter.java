package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.Scanner;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader fileIn = new FileReader(inFileName);
        FileWriter fileOut = new FileWriter(outFileName);

        try {
            Scanner scanner = new Scanner(fileIn);
            String inFileString = "";
            String outFileString = "";
            while (scanner.hasNextLine()) {
                inFileString = inFileString + scanner.nextLine();
            }
            for (int i = 0; i < inFileString.length(); i++) {
                if (filter.indexOf(inFileString.charAt(i)) == -1) {
                    outFileString = outFileString + inFileString.charAt(i);
                }
            }
            fileOut.write(outFileString);


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
        String filter = "- —,.()";
        filterFile(filename, outFile, filter);
    }
}
