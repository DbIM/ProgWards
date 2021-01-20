package ru.progwards.java1.lessons.queues;

import java.util.PriorityQueue;

public class OrderQueue {
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

    public static void main(String[] args) {
        OrderQueue oq = new OrderQueue();
        oq.add(new Order(11100.0));
        oq.add(new Order(26206.0));
        oq.add(new Order(11274.0));
        oq.add(new Order(1892.0));
        oq.add(new Order(25531.0));
        oq.add(new Order(6996.0));
        oq.add(new Order(1135.0));
        oq.add(new Order(12454.0));
        oq.add(new Order(8186.0));
        oq.add(new Order(16585.0));
        oq.add(new Order(15326.0));
        oq.add(new Order(23366.0));
        oq.add(new Order(17812.0));
        oq.add(new Order(20811.0));
        oq.add(new Order(19808.0));
        oq.add(new Order(12714.0));
        oq.add(new Order(10281.0));
        oq.add(new Order(14527.0));
        oq.add(new Order(27423.0));
        oq.add(new Order(12659.0));
        oq.add(new Order(23425.0));
        oq.add(new Order(22312.0));
        oq.add(new Order(5979.0));
        Order o = oq.get();
        while (o != null) {
            System.out.println(o);
            o = oq.get();
        }
    }
}


//2.1 Создать отдельный класс Order
class Order implements Comparable<Order>{
    @Override
    public String toString() {
        return "Order: " +
                "sum=" + sum +
                ", num=" + num +
                ", startNum=" + startNum +
                ", priority=" + priority +
                ' ';
    }

    //2.2 Создать приватное свойство double sum  - сумма заказа
    private double sum;
    //2.3 Создать приватное свойство int num  - номер заказа
    private int num;
    static int startNum = 1;
    int priority;
    //2.4 Создать конструктор public Order(double sum) -
    // для номера заказа создать систему автонумерации, начиная с 1
    public Order(double sum){
        this.sum = sum;
        num = startNum;
        startNum++;
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
        if (priority == o.priority) {
            return Integer.compare(num, o.getNum());
        }
        else {
            return Integer.compare(priority, o.priority);
        }
    }
}
