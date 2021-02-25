package ru.progwards.java1.lessons.files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OrderProcessor {
    //3.1 Реализовать class Order со следующим свойствами
    //public String shopId - идентификатор магазина
    //public String orderId - идентификатор заказа
    //public String customerId - идентификатор покупателя
    //public LocalDateTime datetime - дата-время заказа (из атрибутов файла - дата последнего изменения)
    //public List<OrderItem> items - список позиций в заказе, отсортированный по наименованию товара
    //public double sum - сумма стоимости всех позиций в заказе
    class Order {
        public String shopId;
        public String orderId;
        public String customerId;
        public LocalDateTime datetime;
        public List<OrderItem> items;
        public double sum;
    }
    //3.2 Реализовать class OrderItem со следующим свойствами
    //public String googsName - наименование товара
    //public int count - количество
    //public double price - цена за единицу
    class OrderItem {
        public String googsName;
        public int count;
        public double price;
    }

    //Реализовать класс OrderProcessor со следующими методами
    //3.3 конструктор public OrderProcessor(String startPath) - инициализирует класс, с указанием начальной папки для хранения файлов
    public OrderProcessor(String startPath){
        Path pathStart = Paths.get(startPath);
    }

    //3.4 метод public int loadOrders(LocalDate start, LocalDate finish, String shopId) -
    // загружает заказы за указанный диапазон дат, с start до finish, обе даты включительно.
    // Если start == null, значит нет ограничения по дате слева,
    // если finish == null, значит нет ограничения по дате справа,
    // если shopId == null - грузим для всех магазинов
    // При наличии хотя бы одной ошибке в формате файла, файл полностью игнорируется, т.е.
    // Не поступает в обработку. Метод возвращает количество файлов с ошибками.
    // При этом, если в классе содержалась информация, ее надо удалить
    public int loadOrders(LocalDate start, LocalDate finish, String shopId){

    }






    //3.5 метод public List<Order> process(String shopId) - выдать список заказов в порядке обработки (отсортированные по дате-времени), для заданного магазина. Если shopId == null, то для всех
    //
    //3.6 метод public Map<String, Double> statisticsByShop() - выдать информацию по объему продаж по магазинам (отсортированную по ключам): String - shopId, double - сумма стоимости всех проданных товаров в этом магазине
    //
    //3.7 метод public Map<String, Double> statisticsByGoods() - выдать информацию по объему продаж по товарам (отсортированную по ключам): String - goodsName, double - сумма стоимости всех проданных товаров этого наименования
    //
    //3.8 метод public Map<LocalDate, Double> statisticsByDay() - выдать информацию по объему продаж по дням (отсортированную по ключам): LocalDate - конкретный день, double - сумма стоимости всех проданных товаров в этот день

}
