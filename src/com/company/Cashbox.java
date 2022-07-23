package com.company;

import com.company.produkts.Produkt;
import com.company.servises.CashboxServis;

public class Cashbox implements CashboxServis {

    @Override
    public int getTotalSum(Basket basket, Catalog catalog) {
        return basket.getProductsInBasket().entrySet().stream().mapToInt(entry -> {
            String key = entry.getKey();
            Produkt produkt = catalog.getProduktByName(key);
            int count = entry.getValue();
            return produkt.getPrice() * count;
        }).sum();
    }
}