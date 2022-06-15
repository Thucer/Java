/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.windowmaster;


import java.util.Scanner;


/**
 *
 * @author John
 * 6/12/22
 * A note on usage, this program seems to work in most cases however, if the user,
 * for whatever reason, enters a numeral value followed by the character f such as,
 * '4f' or '3f' or any other combination in that pattern it is not caught by the catch
 * block. I believe this is because floats are often defined with a numeral followed
 * by the f character. I am unsure how to correct this, though it does not impact 
 * functionality as the program still reads '3f' as a float value of 3.
 */
public class WindowMaster {

    //Scanner is declared as a class variable as multiple methods require it
    Scanner input = new Scanner(System.in);
    //gets dimensions from user
    public float[] getDimensions()
    {
        float height = 0, width = 0;
        boolean isAFloat = false, firstParam = false;
        
        do{
          try{
            if(!firstParam){
            System.out.print("What is the window height, in feet: ");
            height = Float.parseFloat(input.nextLine());
            //Evaluates whether the first parameter, cost, meets the guidelines
            firstParam = true;
            }
            System.out.print("What is the window width, in feet: ");
            width = Float.parseFloat(input.nextLine());
            //Only passes when both statements are valid
            isAFloat = true;
          }catch (NumberFormatException e){
              System.out.println("Sorry, that was not a valid float value, please "
                       + "enter numeric values only.");
          }
          }while(!isAFloat);
        float [] dimensionArray = {height, width};
        
        return dimensionArray;        
    } 
    //gets costs
    public float[] getCosts()
    {
        float glassC = 0, trimC = 0;
        boolean isAFloat = false, firstParam = false;
        do{
          try{
            if(!firstParam){  
            System.out.print("What is the cost of glass per square foot: ");
            glassC = Float.parseFloat(input.nextLine());
            firstParam = true;
            }
            System.out.print("What is the cost of trim per linear foot: ");
            trimC = Float.parseFloat(input.nextLine());
            isAFloat = true; 
          }catch (NumberFormatException e){
              System.out.println("Sorry, that was not a valid float value, please "
                       + "enter numeric values only.");
          } 
        }while(!isAFloat);
        float[] costArray = {glassC,trimC};

        return costArray;
    }
    //gets number of windows
    public int getNumber()
    {
        int numWin = 0;
        boolean isANum = false;
        do{
           try{
            System.out.print("How many windows will be installed: ");
            numWin = Integer.parseInt(input.nextLine());
            isANum = true;
           }catch (NumberFormatException e){
               System.out.println("Sorry, that was not a valid integer, please "
                       + "enter whole number values only.");
           }
        }while(!isANum);
        return numWin;
    }
    public String calculate(float[] a, float[] b)
    {
        float perimeter = 2*a[0]+2*a[1], area = a[0]*a[1];
        float glassCost = b[0]*area, trimCost = b[1]*perimeter;
    
        //Costs are formatted using String.format
        return "Each window has perimeter of "+perimeter+" feet and an"
                + " area of "+area+" feet squared.\nThe glass will cost $"+
                String.format("%.2f", glassCost)+" and the trim will cost $"+
                String.format("%.2f",trimCost)+" per window. The total cost of "
                + "the project is $: "+ 
                String.format("%.2f", ((glassCost+trimCost)*getNumber()));
    }
    //START method main
        public static void main(String[] args) {
        WindowMaster run = new WindowMaster();
        System.out.print(run.calculate(run.getDimensions(), run.getCosts()));
        
    }
}
