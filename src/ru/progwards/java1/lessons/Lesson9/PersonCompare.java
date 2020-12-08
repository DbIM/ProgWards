package ru.progwards.java1.lessons.Lesson9;

abstract class PersonCompare {
    public int compare(Person p1, Person p2) {
        return 0;

/*        PersonCompare personCompare = new PersonCompare() {
            @Override
            public int compare(Person p1, Person p2) {
                return (p1.name.compareTo(p2.name));
            }
        };*/
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

//Правильные ответы:
// В стеке хранятся переменные,
// В куче хранятся объекты,
// Использование кучи медленнее за счет накладных расходов на выделение памяти

//Правильный ответ:
// int i = 0; → и значение и переменная будут в стеке,
// String s = "Привет!" → значение будет в куче, переменная будет в стеке

//Правильный ответ: String name = "Вася";
//someFunction(name); → someFunction не сможет изменить значение name, Person p = new Person("Вася");
//someFunction(p); → someFunction сможет изменить значение name

//Правильный ответ: Integer[] number = {1, 2, 13, 66};
//someFunction(number); → someFunction сможет изменить значение в number, Integer number = 22;
//someFunction(number); → someFunction не сможет изменить значение в number

//    Правильный ответ: Integer number = 22;
//        someFunction(number); → someFunction не сможет изменить значение в number, Integer[] number = {1, 2, 13, 66};
//        someFunction(number); → someFunction сможет изменить значение в number

//Правильный ответ: MathContext mathContext = new MathContext(3);
//BigDecimal result = new BigDecimal("3.3333", mathContext); → 3.33,
//BigDecimal bigDec1 = BigDecimal.valueOf(10);
//BigDecimal bigDec2 = BigDecimal.valueOf(3);
//BigDecimal result = bigDec1.divide(bigDec2); → Так нельзя, будет ошибка во время выполнения, BigDecimal bigDec1 = BigDecimal.valueOf(10);
//BigDecimal bigDec2 = BigDecimal.valueOf(3);
//BigDecimal result = bigDec1.divide(bigDec2, 5, RoundingMode.HALF_UP); → 3.33333