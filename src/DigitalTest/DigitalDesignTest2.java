package DigitalTest;

public class DigitalDesignTest2 {
    public static boolean isDigit(char inputChar) {
        return Character.isDigit(inputChar);
    }

    public static String createNewString(int start, char[] inputCharArray) {
        String resultString = "";
        char[] newCharArray = new char[inputCharArray.length];
        System.arraycopy(inputCharArray, start, newCharArray, start, inputCharArray.length - start);
        for (int i = 0; i < newCharArray.length; i++) {
            if (newCharArray[i] == ']') {
                break;
            }
            if (newCharArray[i] == '[') {
                continue;
            }
            if (!isDigit(newCharArray[i])) {
                resultString = resultString + newCharArray[i];
            }
        }
        return resultString;
    }


    public static String repeatInputString(String inputString) {
        String finalString = "";
        String newString = "";
        char[] chars = inputString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isDigit(chars[i])) {
                int digit = Integer.parseInt(String.valueOf(chars[i]));
                int x = i + 1;
                newString = createNewString(x, chars);
                for (int c = 0; c < digit - 1; c++) {
                    finalString = finalString + newString;
                }
            }
            if (chars[i] == '[' || chars[i] == ']') {
                continue;
            }
            if (!isDigit(chars[i]) && chars[i] != '[' && chars[i] != ']') {
                finalString = finalString + chars[i];
            }
        }
        return finalString;
    }

    public static void main(String[] args) {
        String test = "3[abc]4[de]f";
        String test2 = "2[3[x]y]";
        System.out.println("Строка на вход: " + test);
        System.out.println("Строка на выход: " + repeatInputString(test));
        System.out.println("Строка на вход: " + test2);
        System.out.println("Строка на выход: " + repeatInputString(test2));
    }
}
