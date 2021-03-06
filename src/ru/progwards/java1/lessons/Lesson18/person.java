package ru.progwards.java1.lessons.Lesson18;

import ru.progwards.java1.lessons.test.Person;

import java.util.Date;
import java.util.Locale;

public class person {
    static class Person {
        public String name;
        public Date birth;
        public double salary;

        Person(String name, Date birth, double salary) {
            this.name = name;
            this.birth = birth;
            this. salary = salary;
        }
    }
    //|Вася      |01/01/1970|200 000,00|
    //1. Разделитель значений - "|"
    //2. Порядок вывода значений: name, birth, salary
    //3. Для имени name, ширина 10 символов, прижим влево
    //4. Для дня рождения birth формат "дд/мм/гггг"
    //5. Для зарплаты salary ширина 10 точность 2, и задать разделитель тысяч, в русской раскладке
    static void printPersons(Person[] persons){
        for (int i = 0; i<persons.length;i++) {
            Date date = persons[i].birth;
            Double sal = persons[i].salary;
            Locale locale = new Locale("ru");
            System.out.format(locale, "|%-10s|%td/%tm/%tY|%,10.2f|\n", persons[i].name, date,date,date,sal);
        }
    }

    public static void main(String[] args) {
        Person[] persons = {
                new Person("Вася", new Date(0), 200000.001),
                new Person("Петя", new Date(199234885678L), 55331.123),
                new Person("Коля", new Date(598812345678L), 99999.999)};
        printPersons(persons);
    }
}
