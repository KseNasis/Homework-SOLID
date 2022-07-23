package com.company;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    // Правило S - принцип единственной ответственности. Класс отвечает только за добавление/удаление товаров,
    // а расчетом стоимости корзины занимается класс Cashbox.
    private final Map<String, Integer> productsInBasket = new HashMap<>();

    public Map<String, Integer> getProductsInBasket() {
        return productsInBasket;
    }

    public void add(String product, int value) {
        if (value > 0) {
            productsInBasket.merge(product, value, Integer::sum);
        }
    }

    public void delete(String product) {
        productsInBasket.remove(product);
    }

    public void deleteAll() {
        productsInBasket.clear();
    }

    public void printBasket() {
        int i = 1;
        for (Map.Entry entry : productsInBasket.entrySet()) {
            System.out.print("  [" + i + ") ");
            System.out.print(entry);
            i++;
        }
        System.out.println();
    }

}

