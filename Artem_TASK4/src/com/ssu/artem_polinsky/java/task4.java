/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.artem_polinsky.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Пользователь
 */
public class task4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Item> arrList = new ArrayList<Item>();
        arrList.add(new Item(1,10));
        arrList.add(new Item(2,30));
        arrList.add(new Item(3,20));
        System.out.println("ArrayList:" +arrList); // Вывод содержимого до сортировки
        Collections.sort(arrList);  //Сортировка
        System.out.println("[Sorted by age]");
        System.out.println("ArrayList:" +arrList); // Вывод содержимого после сортировки
        
        System.out.println("\n\n");
        HashSet<Item> itemSet = new HashSet<Item>();
        itemSet.addAll(arrList); // Транспортируем из ArrayList в ItemSet
        System.out.println("HashSet:" +itemSet);
        /*
         * Сейчас мы попытаемся добавить дубликат в HashSet
         * Коллекция не должна добавить дубликат 
         * см метод equals в Item.java
         */
        itemSet.add(new Item(3,20)); //Добавляем дубликат
        System.out.println("HashSet:" +itemSet);
        System.out.println("\n\n");
        
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("Dog", 15);
        scores.put("Cat", 25);
        scores.put("Chicken", 35);
        scores.put("Dog2", 15);
        scores.put("Dog3", 15);
        /*
         * HashMap позволяет по разным ключам получать один и тот же объект
         * В примере по ключам Dog,Dog2,Dog3 можно выйти на один объект Integer-15
         * Map позволяет реализовать связи 1кМ вместо Set где только 1к1
         */
        System.out.println(scores);
        System.out.println("HashMap: "+scores.get("Dog"));
         System.out.println("HashMap: "+scores.get("Dog2"));
    }
}
