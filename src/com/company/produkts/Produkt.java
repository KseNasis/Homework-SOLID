package com.company.produkts;

public class Produkt {
//    Правило O - принцип открытости/закрытости.
//    Все товары наследуются от класса Product, который мы используем в других классах.
//    Это позволяет добавлять новые товары с уникальными свойствами,
//    не меняя основной класс Product и классы, которые его используют
    private String name;
    String category;
    private int price;
    private int rating;

    public Produkt(String name, String category, int price, int rating) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public Produkt(String name, int price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Наименование: " + name + "; Категория: " + category + "; Цена: " + price + " Руб.; "
                + " Рейтинг: " + rating;
    }
}
