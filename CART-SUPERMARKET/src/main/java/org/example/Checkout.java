package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {

    private List<SinglePrice> singlePrices;
    private Map<String, Integer> itemCounts;
    public Checkout(List<SinglePrice> singlePrices) {
        this.singlePrices = singlePrices;
        this.itemCounts = new HashMap<>();
    }


    /* Custom  Methods*/
    public void scan(String item) {
        if(item!="") {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);

        }
    }

    private SinglePrice findPriceRule(String item) {
        for (SinglePrice rule : singlePrices) {
            if (rule.getItem().equalsIgnoreCase(item)) {
                return rule;
            }
        }
        return null;
    }

    public int total() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();

            SinglePrice singlePrice = findPriceRule(item);
            if (singlePrice == null) {
                throw new IllegalArgumentException("Unknown item: " + item);
            }
            total += singlePrice.calculatePrice(count);
        }
        return total;
    }
}
