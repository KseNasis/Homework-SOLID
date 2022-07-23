package com.company.servises;

import com.company.User;

public class NotificationServis implements Notification{
    @Override
    public void notification(User user) {
        System.out.println("Оформлена подписка на оповещения об проводимых акциях: " + user.getEMail());
    }
}
