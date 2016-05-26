/*
 * Array sorting
 */
package com.ssu.artem_polinsky.java;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Artem Polinsky
 * @since 22.04.16
 * @version 1.01
 */
public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("TASK #1");
        System.out.print("ARRAY SIZE = ");
        int size = sc.nextInt();//Integer.parceInt(zzzzzz);
        int[] array = new int[size];

        System.out.println("FILL THE ARRAY: ");

        for(int i=0; i<array.length; i++){
                System.out.print("["+i+"] = ");
                array[i] = sc.nextInt();
                System.out.println("");
        }
        System.out.println("CURRENT ARRAY:");
        showArray(array);
        sortArray(array);
        System.out.println("SORTED ARRAY:");
        showArray(array);
    }
    
    /*
     * It's better, when you using JavaAPI =)
     */
    public static void sortArray(int[] array){
        Arrays.sort(array);
    }

    public static void showArray(int[] array){
            for(int i: array){
                    System.out.print("["+i+"]");
            }
            System.out.println("");
    }
}
