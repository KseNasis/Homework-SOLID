package com.company.servises;

import java.util.HashMap;
import java.util.Map;

public class FastBasket {

    private final Map<String, Integer> productsInFastBasket = new HashMap<>();

    public FastBasket() {
        this.productsInFastBasket.put("Макароны", 1);
        this.productsInFastBasket.put("Пиво", 2);
    }

    public Map<String, Integer> getProductsInFastBasket() {
        return productsInFastBasket;
    }
}
