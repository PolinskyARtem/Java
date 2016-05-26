/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.artem_polinsky.java.models;

/**
 *
 * @author Пользователь
 */
public class Order {
    private int itemId;
    private int count;

    public Order(int itemId, int count){
            this.itemId = itemId;
            this.count = count;
    }
    public int getItemId(){
            return itemId;
    }
    public int getItemCount(){
            return count;
    }    
}
