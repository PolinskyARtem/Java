package com.ssu.artem_polinsky.java.models;

/**
 *
 * @author Artem Polinsky
 */
public class Item {
    
    private int id;
    private String name;
    private int weight;
    private int price;

    public Item(int id, String name, int weight, int price){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public int getId(){
            return id;
    }

    public String getName(){
            return name;
    }

    public int getWeight(){
            return weight;
    }

    public int getPrice(){
            return price;
    }

    @Override
    public String toString(){
            return id+" "+name+" "+weight+"g. "+price+" RUR";
    }  
}
