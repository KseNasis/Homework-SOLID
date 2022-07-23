package com.company.produkts;

public class Food extends Produkt {
    private final int weight;

    public Food(String name, int price, int rating, int weight) {
        super(name, price, rating);
        this.category = "продукты";
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + " Вес: " + weight + " кг " + "\n";
    }
}