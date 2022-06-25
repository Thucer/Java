/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.summativesums;

/**
 *
 * @author John
 */
public class SummativeSums {

    public static void main(String[] args) {
        SummativeSums add = new SummativeSums();
        int[] testArray = {1,2,3,4,5,6};
        System.out.print("The sum of the array is "+add.arraySummation(testArray));
    }
    public int arraySummation(int[] array){
        int total = 0, length = array.length;
        for(int i = 0; i < length; i++)
            total = array[i]+ total;
        return total;
    }
}
