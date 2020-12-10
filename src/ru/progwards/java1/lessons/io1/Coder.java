package ru.progwards.java1.lessons.io1;

import java.io.*;

public class Coder {
    //Создать статический метод
    // public static void codeFile(String inFileName, String outFileName, char[] code, String logName),
    // в котором прочитать файл inFileName
    // и перекодировать его посимвольно в соответствии с заданным шифром,
    // результат записать в outFileName.
    // Шифр задается маcсивом char[] code,
    // где каждому символу symbol оригинального файла
    // соответствует символ code[(int)symbol] выходного файла.
    // В случае ошибок, в файл с именем logName вывести название ошибки
    // через метод класса Exception - getMessage()
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName)
    {
        try
        {
            FileInputStream reader = new FileInputStream(inFileName);
            FileOutputStream writer = new FileOutputStream(outFileName);
            try
            {
                byte[] bytes = reader.readAllBytes();
                for (int i = 0; i < bytes.length; i++)
                    bytes[i] = (byte) code[bytes[i]];
                writer.write(bytes);
            } finally
            {
                writer.close();
                reader.close();
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e)
        {
            toLog(logName, e.getMessage());
        }
    }

    public static void toLog(String logName, String msg)
    {
        System.out.println(msg);
        try
        {
            FileWriter log = new FileWriter(logName, true);
            try
            {
                log.write(msg + "\n");
            } finally
            {
                log.close();
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    /*{
        FileInputStream fileIn = null;
        FileOutputStream outFile = null;
        FileWriter logFile = null;
        try {
            logFile = new FileWriter(logName, true);
            try {
                fileIn = new FileInputStream(inFileName);
                byte[] bytes = fileIn.readAllBytes();
                byte[] newCode = new byte[code.length];
                for (int i = 0; i < newCode.length; i++) {
                    newCode[i] = (byte) code[bytes[i]];
                }
                outFile = new FileOutputStream(outFileName);
                outFile.write(newCode);

            } catch (IOException | ArrayIndexOutOfBoundsException e) {
                logFile.write(e.getMessage());
            } finally {
                logFile.close();
                if (fileIn != null) fileIn.close();
                if (outFile != null) outFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        String filename = "src\\ru\\progwards\\java1\\lessons\\io1\\file1111.txt";

    }
}

