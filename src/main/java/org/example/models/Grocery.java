package org.example.models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void startGrocery() {

        int choice;

        do{
            System.out.println("Choose your move= 0:exit, 1:add, 2:remove ");
            choice =scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Eklemek istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Çıkarmak istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
            }

        }

        while (choice !=0);
        scanner.close();


    }

    public static void addItems(String items) {
        String[] splitItems = items.split(",");
        for(String item: splitItems){
            String trimmed = item.trim();
            if(checkItemIsInList(trimmed)){
                System.out.println("You already have this item in your bag: " + item);
                printSorted();
            }
            else {
                groceryList.add(trimmed);
                printSorted();
            }
        }

    }

    public static void removeItems(String items) {
        String[] splitItems = items.split(",");
        for(String item: splitItems){
            String trimmed = item.trim();
            if(!checkItemIsInList(trimmed)){
                System.out.println("You don not have this item in your bag: " + item);
                printSorted();
            }
            else {
                groceryList.remove(trimmed);
                printSorted();
            }
        }

    }

    private static boolean checkItemIsInList(String item){
        return groceryList.contains(item);

    }

    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println("Items in your bag: " + groceryList);
    }



}
