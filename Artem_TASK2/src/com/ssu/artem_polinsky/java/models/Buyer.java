/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.artem_polinsky.java.models;

import java.util.ArrayList;

/**
 *
 * @author Пользователь
 */
public class Buyer {
    private int id;
    private String name;
    private ArrayList<Order> orderList = new ArrayList<>();

    public Buyer(int id, String name){
            this.id = id;
            this.name = name;
    }

    public int getId(){
            return id;
    }

    public String getName(){
            return name;
    }

    public ArrayList<Order> getOrderList(){
            return orderList;
    }
    
    @Override
    public String toString(){
            return id+" "+name;
    }  
}
