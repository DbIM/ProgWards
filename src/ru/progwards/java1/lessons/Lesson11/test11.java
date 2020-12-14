package ru.progwards.java1.lessons.Lesson11;

import java.io.IOException;

public class test11 {

    //правильный метод
    public void test(int n) throws IOException {
        try {
            doSomething(n);
        }
        catch (Throwable e){
            System.out.println(e.getMessage());
            throw new IOException();
        }
            finally {
            System.out.println("finally executed");
        }
    }
}

//Правильные ответы:
// try-with-resources работает с классами, реализующими AutoClosable,
// Выбрасывание исключения достаточно ресурсоемкая операция,
// Существуют проверяемые и непроверяемые исключения

//Правильный ответ:
//doExceptions 1
//Exception in try (suppressed)
//Exception in finally
//→ неверный вариант,
//doExceptions 1
//Exception in finally
//Exception in try (suppressed)
//→ значение-параметра = 0,
//doExceptions 1
//doExceptions 2
//Exception in finally
//→ значение-параметра = 1
