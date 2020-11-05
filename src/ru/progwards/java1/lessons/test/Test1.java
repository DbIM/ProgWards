package ru.progwards.java1.lessons.test;

public class Test1 {
    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 1;
        System.out.println(a.compareTo(b));
    }

    public int compareTo(Rectangle anRectangle) {
        if (this.compareTo(anRectangle) == 1) {
            return Integer.parseInt((this + " > " + anRectangle + " : 1"));
        } else if (this.compareTo(anRectangle) == 0) {
            return Integer.parseInt((this + " = " + anRectangle + " : 0"));
        }
        return Integer.parseInt((this + " < " + anRectangle + " : -1"));
    }

    public int sumArrayItems(int[] a){
        int k = 0;
        for(int i=0;i<a.length;i++){
            k+=a[i];
        }
        return k;
    }

    static String textGrade(int grade) {
        if (grade == 0) {
            return ("не оценено");
        } else if (grade >= 1 && grade <= 20) {
            return ("очень плохо");
        } else if (grade >= 21 && grade <= 40) {
            return ("плохо");
        } else if (grade >= 41 && grade <= 60) {
            return ("удовлетворительно");
        } else if (grade >= 61 && grade <= 80) {
            return ("хорошо");
        } else if (grade >= 81 && grade <= 100) {
            return ("отлично");
        } else {
            return ("не определено");
        }
    }

    static long factorial(long n) {
        long i = 1;
        if (n == 0) {
            return (1);
        } else {
            while (n >= 1) {
                i = i * n;
                n--;
            }
            return i;
        }
    }

    static int addAsStrings(int n1, int n2){
        return Integer.parseInt((String.valueOf(n1) + String.valueOf(n2)));
    }

}

//Правильные ответы: int a[];,
// int []a = new int[10];,
// int []a = {10, 26, 12, 35};,
// int a[] = {11, 22, 33};//int item = a[1];,
// int a[][][];,
// int a1[], a2[], a3[];
//int a[][] = {a1, a2, a3};,
//int a[][];//int item = a[1][2];

//Правильные ответы: Массив это хранилище объектов заданного типа,
// Размер массива задается при создании, и не может быть изменен в дальнейшем,
// Размер массива можно узнать через свойство length

