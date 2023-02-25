package org.example;


class MultiPrice extends SinglePrice {
   /*Global Variable*/
    private final int specialCount;
    private final int specialPrice;

    /*Constructor*/
    public MultiPrice(String item, int price, int specialCount, int specialPrice) {
        super(item, price);
        this.specialCount = specialCount;
        this.specialPrice = specialPrice;
    }

    /* Custom  Method*/
   public int calculatePrice(int count) {
        int numSpecials = count / specialCount;
        int numRegular = count % specialCount;
        return numSpecials * specialPrice + numRegular * getPrice();
    }


    /* Getter Methods*/
    public int getSpecialCount() {
        return specialCount;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }
};

