package com.company.produkts;

public class Instruments extends Produkt{
    private final String materials;

    public Instruments(String name, int price, int rating, String materials) {
        super(name, price, rating);
        this.category = "инструменты";
        this.materials = materials;
    }

    @Override
    public String toString() {
        return super.toString() + " Материал: " + materials + "\n";
    }
}