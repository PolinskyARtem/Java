/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.artem_polinsky.java;

import com.ssu.artem_polinsky.java.Holders.GeneralHolder;
import com.ssu.artem_polinsky.java.models.Buyer;
import com.ssu.artem_polinsky.java.models.Order;
import java.util.Scanner;

/**
 *
 * @author Пользователь
 */
public class task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneralHolder.getInstance();
        GeneralHolder.getInstance().showMenu();
        Scanner sc = new Scanner(System.in);
        /*
         * 1 - show all items
         * 2 - adding new order
         * 3 - show all buyers
         * 4 - show all orders
         * -1 - shutdown
         */
        while(true){
            System.out.print("\n\nCOMMAND: ");
            int selector = sc.nextInt();
            
            switch(selector){
                case 1:
                    System.out.println("QUERY: SHOW ALL ITEMS");
                    GeneralHolder.getInstance().showMenu();
                    break;
                case 2:
                    System.out.println("QUERY: ADDING NEW BUYER");
                    System.out.print("BUYER NAME: ");                   
                    Buyer b = GeneralHolder.getInstance().addBuyer(sc.next());
                    System.out.println("USE * TO Item ID FOR EXIT FROM ADDING");
                    while(true){
                        System.out.println("ACCEPTING NEW ITEM:");
                        System.out.print("Item ID: ");
                        String itemId = sc.next();
                        if(itemId.contains("*")){
                            GeneralHolder.getInstance()
                                         .showBuyerOrderList(b.getId());
                            break;
                        }else{
                            System.out.print("\n Count: ");
                            int count = sc.nextInt();
                            b.getOrderList().add(new Order(Integer.parseInt(itemId), 
                                                                             count));
                        }
                        System.out.println("ACCEPTED ITEM: "+GeneralHolder.getInstance()
                                .getItemById(Integer.parseInt(itemId)).toString());
                    }

                    break;
                case 3:
                    System.out.println("QUERY: SHOW ALL BUYERS");
                    GeneralHolder.getInstance().showAllBuyers();
                    break;
                case 4:
                    GeneralHolder.getInstance().showAllOrderList();
                    break;
                case -1:
                    System.out.println("GOOD LUCK!");
                    System.exit(1);
                    break;
            }
        }
    }
}
