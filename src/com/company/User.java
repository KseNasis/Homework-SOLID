package com.company;

public class User {
    private final String name;
    private final String address;
    private final String eMail;
    private boolean delivery;
    private boolean message;
    private boolean vip;
    Basket basket;

    public User() {
        this.name = "Покупатель";
        this.address = "Какой-то город, какая-то улица, какой-то дом";
        this.eMail = "Какой-то@email.com";
        this.delivery = false;
        this.message = false;
        this.vip = false;
        this.basket = new Basket();
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public void setMessage(boolean message) {
        this.message = message;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getEMail() {
        return eMail;
    }

    public boolean isVip() {
        return vip;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public boolean isMessage() {
        return message;
    }
}


