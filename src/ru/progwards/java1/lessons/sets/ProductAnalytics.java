package ru.progwards.java1.lessons.sets;

import java.util.*;

//2.1 Создать класс Product - товар,
class Product {
    //2.2 Создать private String code - уникальный артикул товара
    private String code;
    //2.3 Создать конструктор public Product(String code)
    public Product(String code) {
        this.code = code;
    }
    //2.4 Метод public String getCode()
    public String getCode() {
        return code;
    }
}


//2.5 Создать класс Shop - магазин
class Shop {
    //2.6 Создать private List<Product> products - товары имеющиеся в магазине
    private List<Product> products;
    //2.7 Создать конструктор public Shop(List<Product> products)
    public Shop(List<Product> products) {
        this.products = products;
    }
    //2.8 Создать метод public List<Product> getProducts()
    public List<Product> getProducts() {
        return products;
    }
}


public class ProductAnalytics {

//2.10 Создать private List<Shop> shops - список магазинов
//2.11 Создать private List<Product> allProducts - список всех товаров
    private List<Shop> shops; //список магазинов
    private List<Product> allProducts; //список всех товаров

//2.12 Создать конструктор  public ProductAnalytics(List<Product> products, List<Shop> shops)
    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops;
        this.allProducts = products;
    }
//2.13 Создать функцию public Set<Product> existInAll() - товары из products, которые имеются во всех магазинах
    public Set<Product> existInAll(){
        Set<Product> products = new HashSet<Product>(allProducts);
        Iterator shopIterator = shops.iterator();
        while (shopIterator.hasNext()) {
            products.retainAll(new HashSet<Product>(((Shop) shopIterator.next()).getProducts()));
        }
        return products;
    }

//2.14 Создать функцию public Set<Product> existAtListInOne() - товары из products, которые имеются хотя бы в одном магазине
    public Set<Product> existAtListInOne(){
        Iterator shopIterator = shops.iterator();
        Set<Product> products = new HashSet<Product>(((Shop) shopIterator.next()).getProducts());
        while (shopIterator.hasNext()) {
            products.addAll(new HashSet<Product>(((Shop) shopIterator.next()).getProducts()));
        }
        products.retainAll(allProducts);
        return products;
}
//2.15 Создать функцию public Set<Product> notExistInShops() - товары из products, которых нет ни в одном магазине
    public Set<Product> notExistInShops(){
        Set<Product> products = new HashSet<Product>(allProducts);
        Iterator shopIterator = shops.iterator();
        while (shopIterator.hasNext()) {
            products.removeAll(new HashSet<Product>(((Shop) shopIterator.next()).getProducts()));
        }
        return products;
}
//2.16 Создать функцию public Set<Product> existOnlyInOne() - товары из products, которые есть только в одном магазине
    public Set<Product> existOnlyInOne(){
        Set<Product> products = new HashSet<Product>();
        for (int i = 0; i < shops.size(); i++) {
            Set<Product> productsBefore = new HashSet<Product>();
            Set<Product> products1 = new HashSet<Product>();
            Set<Product> productsNow;
            Iterator it = shops.iterator();
            for (int k = 0; k < shops.size(); k++) {
                productsNow = new HashSet<Product>(((Shop) it.next()).getProducts());
                productsNow.retainAll(allProducts);
                if (k < i) {
                    productsBefore.addAll(productsNow);
                } else if (k == i) {
                    products1 = productsNow;
                    products1.removeAll(productsBefore);
                } else {
                    products1.removeAll(productsNow);
                }
            }
            products.addAll(products1);
        }
        return products;
    }
}