package ru.progwards.java1.lessons.RAM;

//Условие:
//Написать на Java программу распаковывания строки.
// На вход поступает строка вида число[строка],
// на выход - строка, содержащая повторяющиеся подстроки.
//
//Пример:
//Вход: 3[xyz]4[xy]z
//Выход: xyzxyzxyzxyxyxyxyz
//
//Ограничения:
//- одно повторение может содержать другое. Например: 2[3[x]y]  = xxxyxxxy
//- допустимые символы на вход: латинские буквы, числа и скобки []
//- числа означают только число повторений
//- скобки только для обозначения повторяющихся подстрок
//- входная строка всегда валидна.


public class DigitalDesignTest4 {
    public static class Unit{
        String content;
        int repeatNum;
        Unit(String inputString, int repeatCount){
            content = inputString;
            repeatNum = repeatCount;
        }
    }

    public static boolean isDigit(char inputChar) {
        return Character.isDigit(inputChar);
    }

    public static String stringAfterBrackets = "";
    public static int firstCounter = 0;
    public static int secondCounter = 0;
    public static int simpleCounter = 0;

    public static String createNewString(char[] inputCharArray) {
        int repeatCount = 0;
        int openBracketsIndex = 0;
        int closeBracketsIndex = 0;
        boolean isThereAnyDigits = false;
        String resultString = "";
        for (int i = 0; i < inputCharArray.length; i++) {
            if (isDigit(inputCharArray[i])) {
                isThereAnyDigits = true;
                if (repeatCount == 0) {
                    repeatCount = Integer.parseInt(String.valueOf(inputCharArray[i]));
                    if (simpleCounter == 0){
                        simpleCounter = repeatCount;
                    }
                }
            }
            if (inputCharArray[i] == '[') {
                if (openBracketsIndex == 0) {
                    openBracketsIndex = i;
                }
            }
            if (inputCharArray[i] == ']') {
                closeBracketsIndex = i;
            }
            resultString = resultString + inputCharArray[i];
        }
        if (isThereAnyDigits) {
            String stringInBrackets = resultString.substring(openBracketsIndex + 1, closeBracketsIndex);
            Unit unit = new Unit(stringInBrackets, simpleCounter);
            stringAfterBrackets = resultString.substring(closeBracketsIndex + 1);
            if (firstCounter > 0) {
                secondCounter = repeatCount;
            }
            if (firstCounter == 0) {
                firstCounter = repeatCount;
            }

            String result = createNewString(unit.content.toCharArray());
            return result;
        }
        if (!isThereAnyDigits) {
            if (openBracketsIndex > 0 && closeBracketsIndex > 0) {
                String stringInBrackets = resultString.substring(openBracketsIndex, closeBracketsIndex - 1);
                String stringAfterBrackets = resultString.substring(closeBracketsIndex);
                String finalString = "";
                for (int k = 0; k < repeatCount; k++) {
                    finalString = finalString + stringInBrackets;
                }
                finalString = finalString + stringAfterBrackets;
                return finalString;
            } else {
                String finalString = "";
                String finalString2 = "";
                if (secondCounter > 0) {
                    for (int k = 0; k < secondCounter; k++) {
                        finalString2 = finalString2 + resultString;
                    }
                }
                if (firstCounter > 0) {
                    for (int k = 0; k < firstCounter; k++) {
                        if (!finalString2.equals("")) {
                            finalString = finalString + finalString2 + stringAfterBrackets;
                        } else {
                            if ((k + 1) >= firstCounter) {
                                finalString = finalString + resultString + stringAfterBrackets;
                                break;
                            }
                            finalString = finalString + resultString;
                        }
                    }
                    firstCounter = 0;
                    secondCounter = 0;
                    stringAfterBrackets = "";
                    return finalString;
                } else {
                    char[] almostResult = resultString.toCharArray();
                    resultString = "";
                    for (int i = 0; i < almostResult.length; i++) {
                        if (almostResult[i] != '[' && almostResult[i] != ']') {
                            resultString = resultString + almostResult[i];
                        }
                    }
                    return resultString;
                }
            }
        }
        return "";
    }


    public static String repeatInputString(String inputString) {
        char[] chars = inputString.toCharArray();
        String resultString = createNewString(chars);
        return resultString;
    }

    public static void main(String[] args) {
        String test = "2[ab]c";
        String test2 = "2[3[x]y]";
        String test3 = "[ababc]";
        String test4 = "2[a[3[4[b]c]]]";
        System.out.println("Строка на вход: " + test);
        System.out.println("Строка на выход: " + repeatInputString(test));
        System.out.println("Строка на вход: " + test2);
        System.out.println("Строка на выход: " + repeatInputString(test2));
        System.out.println("Строка на вход: " + test3);
        System.out.println("Строка на выход: " + repeatInputString(test3));
        System.out.println("Строка на вход: " + test4);
        System.out.println("Строка на выход: " + repeatInputString(test4));
    }
}