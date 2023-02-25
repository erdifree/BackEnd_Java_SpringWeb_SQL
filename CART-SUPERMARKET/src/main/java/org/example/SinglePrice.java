package org.example;

public class SinglePrice implements PriceRule{

    /*Global Variable*/
    private final String item;
    private final int price;

    /*Constructor*/
    public SinglePrice(String item, int price) {
        this.item = item;
        this.price = price;

    }
    /* Interface Override method*/
    @Override
    public int calculatePrice(int count) {
        return price*count;
    }

    /* Getters Method*/
    public String getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }
};
