package DigitalTest;

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

import java.io.IOException;
import java.util.Stack;

public class DigitalDesignTest {
    //Задача решается посредством использования стека
    private static Stack<Unit> stack = new Stack<Unit>();

    public static void main(String[] args) {
        //объявление переменной для проверки входной строки на предмет окончания
        int inputString = -1;
        // cчетчик повторов
        int repeatCount = 0;
        //бесконечный цикл программы
        while (true) {
            //проверка консольной строки посимвольно
            try {
                inputString = System.in.read();
            } catch (IOException e) {
                System.exit(1);
            }
            //если строка завершилась то прерываем цикл
            if (inputString == -1) {
                break;
            }
            //если следующий символ: цифра
            if (Character.isDigit(inputString)) {
                //в счетчик повторов заносим цифру и проверяем следующий символ.
                repeatCount = 10 * repeatCount + Character.getNumericValue(inputString);
                //если следующий символ: открывающая скобка
            } else if (inputString == '[') {
                //то помещаем в стек экземпляр класса Unit
                //c хранящимся значением переменной счетчика повторов
                stack.push(new Unit(repeatCount));
                //и обнуляем счетчик
                //на случай если внутри скобок тоже будут какие-то цифры
                repeatCount = 0;
                //если следующий символ: закрывающая скобка
            } else if (inputString == ']') {
                //извлекаем из стека верхний экземпляр класса Unit с содержащимися в нем значениями
                Unit unit = stack.pop();
                //формируем строку
                String resultString = unit.sb.toString();
                //вызываем метод формирования строки соглсано т.з.
                add(unit.count, resultString);
                //вновь обнуляем счетчик
                repeatCount = 0;
            } else {
                add(repeatCount, Character.toString((char) inputString));
                repeatCount = 0;
            }
        }
    }

    private static void add(int repeatCount, String s) {
        //на случай если счетчик нулевой то выполним цикл один раз
        if (repeatCount < 1) {
            repeatCount = 1;
        }
        for (int i = 0; i < repeatCount; ++i) {
            //проверяем содержимое стека
            //возвращаем верхний элемент
            if (!stack.empty()) {
                stack.peek().sb.append(s);
            } else {
                System.out.print(s);
            }
        }
    }

    //Класс для элементов счетчика повторов и строки
    public static class Unit {
        public int count;
        public StringBuilder sb;
        public Unit(int inputCount) {
            count = inputCount;
            sb = new StringBuilder();
        }
    }

    ;
}
