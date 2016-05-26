/*
 * Класс участвующий в демонстрации JCF
 */
package com.ssu.artem_polinsky.java;

/**
 *
 * @author Пользователь
 */
public class Item implements Comparable<Item>{
    private int id;
    private int age;
    
    public Item(int id, int age){
        this.id = id;
        this.age = age;
    }
    
   @Override
   public String toString(){
       return "id: "+id+" age:"+age;
   }

    /*
    * Метод используемый при автосортировке объектов в HashSet
    * Сортировка по возврасту
    * Переопределен
    */
    @Override
    public int compareTo(Item o) {
        if(age > o.age){
            return 1;
        }else if(age < o.age){
            return -1;
        }else{
            return 0;
        }
    }
    
    /*
    * Метод используемый при автосортировке объектов в HashSet
    * Переопределен 
    */    
    @Override
    public int hashCode(){
        return id;
    }
    
   /*
    * Метод используемый HashMap
    * Не дает существовать дубликатам в коллекции
    * Переопределен 
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }
}
