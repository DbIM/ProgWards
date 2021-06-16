package ru.progwards.java1.lessons.advanced;

import java.util.List;
// который вначале сортирует list по возрасту, а затем выводит его на консоль.
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
}