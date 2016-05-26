/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.artem_polinsky.java.Holders;

import com.ssu.artem_polinsky.java.models.Buyer;
import com.ssu.artem_polinsky.java.models.Item;
import com.ssu.artem_polinsky.java.models.Order;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Пользователь
 */
public class GeneralHolder {
    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<Buyer> buyerList = new ArrayList<>();
    
    private GeneralHolder() {
        loadItems();
    }
    
    private void loadItems(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                                    new FileInputStream("itemList.txt"),
                                                        "windows-1251"));
            String s = null;
            while((s = br.readLine())!= null){
                    //SPLITTER ,
                    String[] _args = s.split(",");
                    itemList.add(new Item(itemList.size(), _args[0], 
                                          Integer.parseInt(_args[1]), 
                                          Integer.parseInt(_args[2])));
                    
            }
            br.close();
            System.out.println("LOADED "+itemList.size()+" items");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public Item getItemById(int itemId){
	for(Item item : itemList){
		if(item.getId() == itemId){
			return item;
		}
	}
	return null;
    }

    public void showMenu(){
        System.out.println("====== MENU ======");
        for(Item item: itemList){
            System.out.println(item.toString());
        }
    }
    
    public void showBuyerOrderList(int id){
        for(Buyer buyer: buyerList){
            if(buyer.getId() == id){
                System.out.println("-BUYER: "+buyer.getName());
                System.out.println("--ORDER LIST:");
                int total_price = 0;
                for(Order order: buyer.getOrderList()){
                    Item it = getItemById(order.getItemId());
                    System.out.println("--+"+it.getName()+" "+
                                       it.getWeight()*order.getItemCount()+"g. "+
                                       it.getPrice()*order.getItemCount()+" RUR");
                    total_price+=it.getPrice()*order.getItemCount();
                }
                System.out.println("\n!!! TOTAL PRICE: "+total_price);
                break;
            }
        }
    }
    
    public void showAllOrderList(){
        for(Buyer buyer: buyerList){
                System.out.println("-BUYER: "+buyer.getName());
                System.out.println("--ORDER LIST:");
                int total_price = 0;
                for(Order order: buyer.getOrderList()){
                    Item it = getItemById(order.getItemId());
                    System.out.println("--+"+it.getName()+" "+
                                       it.getWeight()*order.getItemCount()+"g. "+
                                       it.getPrice()*order.getItemCount()+" RUR");
                    total_price+=it.getPrice()*order.getItemCount();
                }
                System.out.println("\n!!! TOTAL PRICE: "+total_price);
        }
    }
    
    public Buyer addBuyer(String name){
        Buyer b = new Buyer(buyerList.size(),name);
        buyerList.add(b);
        return b;
    }
    
    public void showAllBuyers(){
        System.out.println("LIST OF BUYERS");
        for(Buyer b: buyerList){
           System.out.println("+"+b.toString());
        }
    }
    
    public static GeneralHolder getInstance() {
        return GeneralHolderHolder.INSTANCE;
    }
    
    private static class GeneralHolderHolder {

        private static final GeneralHolder INSTANCE = new GeneralHolder();
    }
}
