/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssu.artem_polinsky.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Пользователь
 */
public class task3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testNPE(); // Вызов метода, который генерирует unchecked NullPointerException
        testAr(); //Вызов метода, который генерирует unchecked ArithmeticException
        testRe(); //Вызов метода, который генерирует checked IOException
        testFe(); //Вызов метода, который генерирует checked FileNotFoundException
        try {
            testWe(); // Вызов метода, который пробрасывает OutOfMemoryError
        } catch (OutOfMemoryError ex) { //Логируем в перехвате
            Logger.getLogger(task3.class.getName()).log(Level.SEVERE, null, ex);
        }finally{ //Завершаем выполнение программы с уведомлением
            System.out.println("ALL WILL BE OK ;)");
            
        }
    }
    
    /*
     * Метод, который генерирует NullPointerException
     */
    public static void testNPE(){
        int[] mass = new int[5];
        mass = null;
        try{
            mass[0] = 1; // Здесь NullPointerException
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
        System.out.println("testNPE successfully!");
    }
    
    /*
     * Метод, который генерирует ArithmeticException
     */
     public static void testAr(){
        try{
            int a = 1/0; // Здесь ArithmeticException
        }catch(ArithmeticException ex){
            ex.printStackTrace();
        }
        System.out.println("testAr successfully!");
    }
     
    /*
     * Метод, который генерирует IOException
     */
      public static void testRe(){
        try{
            Runtime.getRuntime().exec("?.exe"); // Здесь IOException
        }catch(IOException ex){
            ex.printStackTrace();
        }
        System.out.println("testRe successfully!");
    }
      
    /*
     * Метод, который генерирует FileNotFoundException
     */
      public static void testFe(){
        try {
            InputStreamReader isr = new InputStreamReader(
                                    new FileInputStream("?.txt")); //Здесь FileNotFoundException
        } catch (FileNotFoundException ex) {
            Logger.getLogger(task3.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("testFe successfully!");
     }
      
    /*
     * Метод, который генерирует и пробрасывает OutOfMemoryError
     */
      public static void testWe() throws OutOfMemoryError{
          throw new OutOfMemoryError();
     }
}
