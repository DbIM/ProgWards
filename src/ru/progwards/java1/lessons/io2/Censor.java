package ru.progwards.java1.lessons.io2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Создать статический метод public static void censorFile(String inoutFileName, String[] obscene),
// в котором прочитать файл inoutFileName и заменить слова, содержащиеся в String[] obscene на '*',
// соответствующие количеству символов в слове, изменения записать в исходный файл.
// В случае возникновения ошибки, выбросить свое собственное исключение CensorException
// в котором сохранить - строку, полученную у оригинального exception через метод getMessage()
// и имя файла, в котором возникла ошибка.
// В классе перекрыть метод toString(), вернув <имя файла>:<строка ошибки>.
// Класс CensorException разместить в классе Censor
public class Censor {
    private static String onlyChars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    static class CensorException extends RuntimeException {

        String errName;
        String fileName;

        CensorException(String errName, String fileName) {
            this.errName = errName;
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return errName + ":" + fileName;
        }
    }

    public static void censorFile(String inoutFileName, String[] obscene) throws IOException {
        try {
            FileReader reader = new FileReader(inoutFileName);
            Scanner scanner = new Scanner(reader);
            String str = "";
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
            }
            String[] inputFile = str.split(" ");
            for (String s : obscene) {
                for (int i2 = 0; i2 < inputFile.length; i2++) {
                    String testChar = onlyChars(inputFile[i2]);
                    if (s.equals(testChar)) {
                        StringBuilder stringBuilder = new StringBuilder(inputFile[i2]);
                        for (int i = 0; i < inputFile[i2].length(); i++) {
                            if (Character.isLetterOrDigit(inputFile[i2].charAt(i))) {
                                stringBuilder.setCharAt(i, '*');
                            } else {
                                stringBuilder.setCharAt(i, inputFile[i2].charAt(i));
                            }
                        }
                        inputFile[i2] = stringBuilder.toString();
                    }
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String s : inputFile) {
                stringBuilder2.append(s).append(' ');
            }
            stringBuilder2.setLength(stringBuilder2.length() - 1);
            reader.close();

            FileWriter outFile = new FileWriter(inoutFileName);
            outFile.write(stringBuilder2.toString());
            outFile.close();
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "src\\ru\\progwards\\java1\\lessons\\io2\\test.txt";
        String[] obscene = {"day", "count", "two", "storey", "write"};
        censorFile(filename, obscene);
    }

}
//Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).