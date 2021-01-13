package ru.progwards.java1.lessons.sets;

import java.util.List;
import java.util.Set;

public class ProductAnalytics {

    class Product {
        private String code;

        public Product(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    class Shop {
        private List<Product> products;

        public Shop(List<Product> products) {
            this.products = products;
        }

        public List<Product> getProducts() {
            return products;
        }
    }

    private List<Shop> shops;
    private List<ProductAnalytics.Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops;
        this.products = products;
    }

    public Set<Product> existInAll() {
        return null;
    }

    public Set<Product> existAtListInOne() {
        return null;
    }

    public Set<Product> notExistInShops() {
        return null;
    }

    public Set<Product> existOnlyInOne() {
        return null;
    }
}
