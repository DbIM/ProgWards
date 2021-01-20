package ru.progwards.java1.lessons.queues;

import java.util.PriorityQueue;

public class OrderQueue {
    //2.1 Создать отдельный класс Order
    static class Order implements Comparable<Order>{
        //2.2 Создать приватное свойство double sum  - сумма заказа
        private double sum;
        //2.3 Создать приватное свойство int num  - номер заказа
        private int num;
        int startNum = 1;
        int priority;
        //2.4 Создать конструктор public Order(double sum) -
        // для номера заказа создать систему автонумерации, начиная с 1
        public Order(double sum){
            this.sum = sum;
            this.num = startNum++;
            if (sum<=10000) this.priority = 3;
            if (sum>10000 && sum<=20000) this.priority = 2;
            if (sum>20000) this.priority = 1;
        }
        //2.5 Создать геттер public double getSum()
        public double getSum() {
            return sum;
        }
        //2.6 Создать геттер public int getNum()
        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Order o) {
            return Integer.compare(priority, o.priority);
        }
    }
    //2.7 Создать метод, public void add(Order order),
    // размещающий заказы в очередь с приоритетом, разбивая их по 3-м классам
    //3 - заказы до 10000 руб включительно
    //2 - заказы от 10000 до 20000 руб включительно
    //1 - заказы от 20000 руб
    PriorityQueue<Order> priorityQueue = new PriorityQueue<Order>(Order::compareTo);
    public void add(Order order){
            priorityQueue.add(order);
    }

    //2.8 Создать метод, public Order get(),
    // возвращающий первый заказ в очереди для обслуживания.
    // Вначале обслуживаются заказы класса 1, потом 2, потом 3.
    // Внутри каждого класса заказы должны обслуживаться в порядке поступления (по номеру заказа).
    // Метод не выбрасывает исключения, возвращает null в случае пустой очереди.
    public Order get(){
        return priorityQueue.poll();
    }
}
