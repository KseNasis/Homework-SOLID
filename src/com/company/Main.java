package com.company;

import com.company.servises.DeliveryServis;
import com.company.servises.FastBasket;
import com.company.servises.NotificationServis;

import java.util.Scanner;

//SOLID-это аббревиатура, которая обозначает пять принципов ООП и проектирования.
//        S-принцип единственной ответственности(Single Responsibility Principle)
//                  Класс должен выполнять только те функции, для которых он логически предназначен.
//        O-принцип открытости/закрытости(Open Closed Principle)
//                  Программные сущности должны быть открыты для расширения, но закрыты для модификации.
//        L-принцип замены Барбары Лисков (Liskov Substitution Principle)
//                  Наследуй только тогда, когда можешь играть роль за предка.
//        I-принцип сегрегации(разделения)интерфейса(Interface Segregation Principle)
//                  Много интерфейсов, специально предназначенных для клиентов, лучше, чем один интерфейс общего назначения.
//        D-принцип инверсии зависимостей(Dependency Inversion Principle)
//                  Всё зависит от абстракций(интерфейсов), а не от деталей реализации друг друга.

/*
 Пользователь - Список подключенных сервисов с отбражением на экране
 Список товаров
        *Вывод доступных для покупки товаров
        *Создание рандомизированного списка по кол-ву и цене и рейтингу
 Товары
        *Категории, ценам, рейтинг
 Сервисы
        *Фильтрация товаров по Категории, ценам, рейтингу
        *Система доставки
        *Система сообщения об акциях
        *Скидка ВИПа
        Готовая рекомендованная корзина
Корзина
        *Вывод на экран
        *Отмена заказа


*/

public class Main {

    public static void main(String[] args) {
        final double discount = 0.9;
        //  Скидка вынесена в отдельную константу discount
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        Catalog catalog = new Catalog();
        catalog.createRandomCatalog();
        DeliveryServis deliveryServis = new DeliveryServis();
        NotificationServis notificationServis = new NotificationServis();
        Cashbox cashbox = new Cashbox();
        System.out.println("МАГАЗИН");
        System.out.println(""" 
                \nВы можете выбрать дополнительные сервисы, набрав в консоли соответствующий код:
                * Фильтрация товаров по Категории ([Food] [Instruments] [Drinks]), отключение [All]
                * Сортировка товаров по ценам [priceSort]
                * Сортировка товаров по рейтингу [ratingSort]
                * Заказать доставку товара [delivery]
                * Подписка на оповещения об проводимых акциях [notification]
                * Скидка для особого клиента [discount]
                * Показать корзину [Basket], очистить корзину [Clear]
                * Готовая рекомендованная корзина для быстрых покупок [FastBasket]
                """);

        System.out.println("Список возможных товаров для покупки:");
        catalog.printCatalog();
        System.out.println("""
                Для покупки наберите номер товара и количество через пробел,\s
                 или введите `end` для окончания покупки""");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");
            switch (input) {
                case "Food" -> {
                    System.out.println("Включена фильтрация списка по категории \"продукты\"");
                    catalog.filterList("продукты");
                    catalog.printCatalog();
                }
                case "Instruments" -> {
                    System.out.println("Включена фильтрация списка по категории \"инструменты\"");
                    catalog.filterList("инструменты");
                    catalog.printCatalog();
                }
                case "Drinks" -> {
                    System.out.println("Включена фильтрация списка по категории \"напитки\"");
                    catalog.filterList("напитки");
                    catalog.printCatalog();
                }
                case "All" -> {
                    System.out.println("Отключена фильтрация списка по категории");
                    catalog.notFilter();
                    catalog.printCatalog();
                }
                case "priceSort" -> {
                    System.out.println("Сортировка списка по цене");
                    catalog.sortList("priceSort");
                    catalog.printCatalog();
                }
                case "ratingSort" -> {
                    System.out.println("Сортировка списка по рейтингу");
                    catalog.sortList("ratingSort");
                    catalog.printCatalog();
// Использование printCatalog() позволяет избежать дублирования кода
                }
                case "delivery" -> {
                    if (!user.isDelivery()) {
                        deliveryServis.delivery(user);
                        user.setDelivery(true);
                    }
                }
                case "notification" -> {
                    if (!user.isMessage()) {
                        notificationServis.notification(user);
                        user.setMessage(true);
                    }
                }
                case "discount" -> {
                    if (!user.isVip()) {
                        System.out.println("!!!Скидка 10% для особого клиента активирована!!!");
                        user.setVip(true);
                    }
                }
                case "Basket" -> {
                    System.out.println("Ваши покупки:");
                    user.basket.printBasket();
                    if (user.isVip()) {
                        System.out.println("Скидка 10% для особого клиента активирована\n Итого: "
                                + cashbox.getTotalSum(user.basket, catalog) * discount + "руб.");
//  Скидка вынесена в отдельную константу discount
                    } else System.out.println("Итого: " + cashbox.getTotalSum(user.basket, catalog) + " руб.");
                }
                case "Clear" -> {
                    System.out.println("корзина очищена");
                    user.basket.deleteAll();
                }

                case "FastBasket" -> {
                    FastBasket fastBasket = new FastBasket();
                    user.basket.getProductsInBasket().putAll(fastBasket.getProductsInFastBasket());
                    System.out.println("Ваши покупки + готовая рекомендованная корзина для быстрых покупок:");
                    user.basket.printBasket();
                }

                default -> {
                    int x = Integer.parseInt(parts[0]);
                    if (((x) < catalog.modifygetCatalog().size()+1) && (x > 0) && (parts.length > 1)) {
// Magics - catalog.modifygetCatalog(). - ссылается на количество элементов в списке, а не на число "9"
                        user.basket.add(catalog
                                .getName(Integer.parseInt(parts[0]) - 1), Integer.parseInt(parts[1]));
                    }
                }
            }
        }
    }
}