package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ////////////Test-Total/////////////////
        /* Using polymorphism to declare items*/
        SinglePrice singlePriceA = new MultiPrice("A", 50, 3, 130);
        SinglePrice singlePriceB = new MultiPrice("B", 30, 2, 45);
        SinglePrice singlePriceC = new SinglePrice("C", 25);
        SinglePrice singlePriceD = new SinglePrice("D", 15);
        List<SinglePrice> prices = Arrays.asList(singlePriceA, singlePriceB, singlePriceC,singlePriceD);
        Checkout checkout = new Checkout(prices);
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("B");
        checkout.scan("D");

         System.out.println("Total: $" + checkout.total() / 100.0);

       /////////Test_incremental////////////////
       /* Scanner scanner=new Scanner(System.in);
        boolean sentinel= true;
        System.out.println("Insert your Product ( example A B C D)");
        while (sentinel){
            String flag=scanner.nextLine();
            checkout.scan(flag);
            System.out.println("Total: $" + checkout.total() / 100.0);
            if(flag ==""){
                sentinel=false;
            }
            System.out.println("Scan another Product ( example A B C D) or press Enter for Pay");
        }*/

    }
}