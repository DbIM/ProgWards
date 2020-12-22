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
            for (String s : obscene) {
                str = str.replaceAll(s, "*".repeat(s.length()));
            }
            reader.close();

            FileWriter outFile = new FileWriter(inoutFileName);
            outFile.write(str);
            outFile.close();
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "src\\ru\\progwards\\java1\\lessons\\io2\\test.txt";
        String[] obscene = {"write", "day", "two", "storey", "count"};
        censorFile(filename, obscene);
    }

}
//Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).