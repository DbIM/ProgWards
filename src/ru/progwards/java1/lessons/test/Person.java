package ru.progwards.java1.lessons.test;

public class Person {
    private String name;
    private int age;
    private String country;
    public Person(){
        country = "RU";
    }
    public Person(String name, int age){
        this();
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
