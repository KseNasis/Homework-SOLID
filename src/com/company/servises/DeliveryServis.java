package com.company.servises;

import com.company.User;

public class DeliveryServis implements Delivery {

    @Override
    public void delivery(User user){
        System.out.println("Заказана доставка по адресу: " + user.getAddress());
    }
}
