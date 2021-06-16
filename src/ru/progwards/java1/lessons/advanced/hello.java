package ru.progwards.java1.lessons.advanced;

public class hello {
    static int sumSequence(int n) {
        if (n == 1)
            return n;
        return sumSequence(n-2)+n;
    }

    static String reverseChars(String str){
        StringBuffer inputString = new StringBuffer(str);
        inputString.reverse();
        return String.valueOf(inputString);
    }

    public static void main(String[] args) {
        System.out.println(sumSequence(3));
    }
}

//Правильный ответ:
// java -classpath ./bin ru.progwards.java2.lessons.lambda.MyClass

//Правильный ответ:
// javac -d bin src/MyClass.java

//-Xmx4096m

//Правильные ответы:
// Метод stream на основе коллекций предоставляют механизм доступа к существующим элементам,
// stream.filter является примером отложенной операции,
// Реальное итерирование по элементам коллекции происходит при вызове эффективной операции

//Правильный ответ:
// Получить объект → get(),
// Возвращает реальный объект, если он != null), иначе то возвращает <значение по умолчанию> → orElse(<значение по умолчанию>),
// Обернуть объект <объект> в Optional → Optional.of(<объект>),
// Выполнить <функция> если реальный объект != null → ifPresent(<функция>),
// Реальный объект != null? → isPresent()


/*
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " " + age;
   }

    void sortAndPrint(List<Person> list){
        list.sort((a, b) -> Integer.compare(a.age, b.age));
        list.forEach(System.out::println);
   }
}*/
