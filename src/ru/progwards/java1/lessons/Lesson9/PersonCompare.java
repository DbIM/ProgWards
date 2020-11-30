package ru.progwards.java1.lessons.Lesson9;

abstract class PersonCompare {
    public int compare(Person p1, Person p2) {
        return 0;

        PersonCompare personCompare = new PersonCompare() {
            @Override
            public int compare(Person p1, Person p2) {
                return (p1.name.compareTo(p2.name));
            }
        };
    }

    private int compare(int compareTo) {
        return compareTo;
    }
}

//Напишите фрагмент кода,
// в котором создайте переменную класса PersonCompare personCompare
// и проинициализируйте ее анонимным классом,
// который перекрывает метод compare
// реализуя его через p1.name.compareTo(p2.name)

//        PersonCompare personCompare = new PersonCompare() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return (p1.name.compareTo(p2.name));
//            }
//        };

//Правильные ответы:
// Локальный класс объявляется в блоке кода,
// Локальный класс видим также как и локальная переменная, внутри того же блока кода,
// За некоторым исключением, локальный класс видит то же самое, что и локальная переменная, внутри того же блока кода