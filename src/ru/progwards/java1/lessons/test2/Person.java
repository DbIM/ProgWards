package ru.progwards.java1.lessons.test2;

public class Person {
    static class Child1{
        String hello(){
            return "привет";
        }
    }

    class Child2{
        String hello(){
            return "servus";
        }
    }
}


//Правильный ответ:
// Располагается внутри какого-либо класса и содержит модификатор static → вложенный класс,
// Разновидность внутреннего класса, располагается внутри любого метода → локальный класс,
// Разновидность локального класса, но существует сам по себе, без переменной → анонимный класс,
// Располагается внутри какого-либо класса и не содержит модификатор static → внутренний класс

//Правильный ответ: public static class Animal {
//public class SaveRec {
//           ....
//  → Так написать нельзя, компилятор выдаст ошибку,
//  public class Person {
//	static class SaveRec {
//           ....
//  → Внутри класса Person можно написать new SaveRec();,
//public class Animal {
//public static class SaveRec {
//           ....
//  → Снаружи класса Animal можно написать new Animal.SaveRec();,
//public class Animal {
//public class SaveRec {
//           ....
//  → Снаружи класса Animal можно написать new Animal().new SaveRec();,
//public class Person {
//   class SaveRec {
//           ....
//  → Внутри класса Person можно написать newPerson().new SaveRec();