package com.company;

import com.company.produkts.Drinks;
import com.company.produkts.Food;
import com.company.produkts.Instruments;
import com.company.produkts.Produkt;
import com.company.servises.Filter;
import com.company.servises.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Catalog implements Filter, Sort {
//    Правило I- принцип сегрегации (разделения) интерфейса.
//    Интерфейсы Filter, Sort разделены.
    private final List<Produkt> catalog = new ArrayList<>();
    private final List<Produkt> modifyCatalog = new ArrayList<>();

    public List<Produkt> getCatalog() {
        return catalog;
    }

    public List<Produkt> modifygetCatalog() {
        return modifyCatalog;
    }

    public Produkt getProduktByName(String name) {
        for (Produkt produkt : getCatalog()) {
            if (name.equals(produkt.getName())) {
                return produkt;
            }
        }
        return null;
    }

    public String getName(int namber) {
        return modifyCatalog.get(namber).getName();
    }

    public int getPriceByName(String name) {
        for (Produkt produkt : getCatalog()) {
            if (name.equals(produkt.getName())) {
                return produkt.getPrice();
            }
        }
        return 0;
    }

    public int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void createRandomCatalog() {
        catalog.add(new Food("Макароны", random(50, 100), random(1, 5), 1));
        catalog.add(new Food("Гречка", random(60, 80), random(1, 5), 1));
        catalog.add(new Food("Картошка", random(40, 120), random(1, 5), 5));
        catalog.add(new Drinks("Пепси", random(100, 150), random(1, 5), 1));
        catalog.add(new Drinks("Кола", random(100, 200), random(1, 5), 0.7));
        catalog.add(new Drinks("Пиво", random(80, 200), random(1, 5), 0.5));
        catalog.add(new Instruments("Молоток", random(200, 500), random(1, 5), "Сталь"));
        catalog.add(new Instruments("Рулетка", random(100, 300), random(1, 5), "Пластик"));
        catalog.add(new Instruments("Лом", random(100, 5000), random(1, 5), "Титан"));
        modifyCatalog.addAll(catalog);
    }

    public void printCatalog() {
        int i = 1;
        for (Produkt product : modifyCatalog) {
            System.out.print(i + ") ");
            System.out.print(product);
            i++;
        }
    }

    public void notFilter() {
        modifyCatalog.clear();
        modifyCatalog.addAll(catalog);
    }

    @Override
    public void filterList(String key) {
        modifyCatalog.clear();
        modifyCatalog.addAll(catalog.stream().filter(value -> value.getCategory().equals(key)).toList());
    }

    @Override
    public void sortList(String key) {
        if (key.equals("priceSort")) {
            modifyCatalog.clear();
            modifyCatalog.addAll(catalog.stream().sorted(Comparator.comparingInt(Produkt::getPrice)).toList());
        } else if (key.equals("ratingSort")) {
            modifyCatalog.clear();
            modifyCatalog.addAll(catalog.stream().sorted(Comparator.comparingInt(Produkt::getRating)).toList());
        }

    }
}
