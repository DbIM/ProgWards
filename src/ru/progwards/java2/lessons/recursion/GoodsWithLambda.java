package ru.progwards.java2.lessons.recursion;

import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GoodsWithLambda {
    //Задача на использование лямбда
    //1.2 Реализовать класс GoodsWithLambda
    private List<Goods> goodsList;

    //1.3 реализовать метод void setGoods(List<Goods> list)
    void setGoods(List<Goods> list) {
        goodsList = new ArrayList<>(list);
    }

    //1.4 реализовать метод
    //public List<Goods> sortByName() - вернуть список, отсортированный по наименованию
    public List<Goods> sortByName() {
        List<Goods> sortedList = new ArrayList<>(goodsList);
        sortedList.sort(Comparator.comparing(good -> good.name));
        return sortedList;
    }

    //1.5 реализовать метод
    //public List<Goods> sortByNumber() - вернуть список, отсортированный по артикулу, без учета регистра
    public List<Goods> sortByNumber(){
        List<Goods> sortedList = new ArrayList<>(goodsList);
        sortedList.sort(Comparator.comparing(product -> product.number.toUpperCase()));
        return sortedList;
    }

    //1.6 реализовать метод
    //public List<Goods> sortByPartNumber() - вернуть список, отсортированный по первым 3-м символам артикула, без учета регистра
    public List<Goods> sortByPartNumber(){
        List<Goods> sortedList = new ArrayList<>(goodsList);
        sortedList.sort(Comparator.comparing(product -> product.number.substring(0,3).toUpperCase()));
        return sortedList;
    }

    //1.7 реализовать метод
    //public List<Goods> sortByAvailabilityAndNumber() - вернуть список, отсортированный по количеству, а для одинакового количества, по артикулу, без учета регистра
    public List<Goods> sortByAvailabilityAndNumber(){
        List<Goods> sortedList = new ArrayList<>(goodsList);
        sortedList.sort((product, product2) -> {
            if(product.available == product2.available) {
                return product.number.compareToIgnoreCase(product2.number);
            } else {
                return Integer.compare(product.available, product2.available);
            }
        });
        return sortedList;
    }

    //1.8 реализовать метод
    //public List<Goods> expiredAfter(instant date) - вернуть список, с товаром, который будет просрочен после указанной даты, отсортированный по дате годности
    public List<Goods> expiredAfter(Instant date){
        return goodsList.stream().takeWhile(goods -> goods.expired.getEpochSecond() <= date.getEpochSecond())
                .sorted(Comparator.comparingLong(goods -> goods.expired.getEpochSecond())).collect(Collectors.toList());
    }

    //1.9 реализовать метод
    //public List<Goods> сountLess(int count) - вернуть список, с товаром, количество на складе которого меньше указанного, отсортированный по количеству
    public List<Goods> сountLess(int count){
        return goodsList.stream().takeWhile(products -> products.available < count).collect(Collectors.toList());
    }

    //1.10 реализовать метод
    //public List<Goods> сountBetween(int count1, int count2) - вернуть список,
    // с товаром, количество на складе которого больше count1 и меньше count2, отсортированный по количеству
    public List<Goods> сountBetween(int count1, int count2){
        Predicate<Goods> predicate = products -> products.available > count1;
        Predicate<Goods> predicate2 = products -> products.available < count2;
        return goodsList.stream().takeWhile(predicate.and(predicate2)).collect(Collectors.toList());
    }
}
