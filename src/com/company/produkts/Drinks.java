package com.company.produkts;

public class Drinks extends Produkt{
//    Правило L-принцип замены Барбары Лисков.
//все товары наследуются от класса Product и могут быть использованы вместо класса-родителя.
    private final double volume;

    public Drinks(String name, int price, int rating, double volume) {
        super(name, price, rating);
        this.category = "напитки";
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + " Объем: " + volume + " Литров" + "\n" ;
    }
}
