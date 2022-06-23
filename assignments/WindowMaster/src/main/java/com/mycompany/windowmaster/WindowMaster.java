/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.windowmaster;


import java.util.Scanner;


/**
 *
 * @author John
 */
public class WindowMaster {

    //Scanner is declared as a class variable as multiple methods require it
    Scanner input = new Scanner(System.in);
    //gets float info from user, ensures entries are not 0
    public float askQuestions(String question){
        float output;
        //switch statement used as one quetsion deals with ints not floats
        switch(question){
            case "How many windows will be installed: ":
                    System.out.print(question);
                    output = Float.parseFloat(input.nextLine());
                    while(output == 0)
                    {
                        System.out.println("Sorry 0 is not a valid amount to "
                                + "install. " + question);
                        output = Float.parseFloat(input.nextLine());
                    }
                /*returns used here instead of break in order to pass control back to caller method */
                return output;
            case "What is the cost of glass per square foot: ":
            case "What is the cost of trim per linear foot: ":
                System.out.print(question);
                    output = Float.parseFloat(input.nextLine());
                    while(output == 0)
                    {
                        System.out.println("Sorry $0.00 is not a valid cost value. "
                                + question);
                        output = Float.parseFloat(input.nextLine());
                    }
                return output;
            default:
                   System.out.print(question);
                    output = Float.parseFloat(input.nextLine());
                    while(output == 0)
                    {
                        System.out.println("Sorry 0 feet is not a valid dimensional "
                    + "value. " + question);
                        output = Float.parseFloat(input.nextLine());
                    }    
        }
        return output;
    }
    public float[] getDimensions()
    {
        float height = 0, width = 0;
        boolean isAFloat = false, firstParam = false;
        
        do{
          try{
            if(!firstParam){
            //System.out.print("What is the window height, in feet: ");
            height = askQuestions("What is the window height, in feet: ");
            //Evaluates whether the first parameter, height, meets the guidelines
            firstParam = true;
            }
            //System.out.print();
            width = askQuestions("What is the window width, in feet: ");
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
            //System.out.print("What is the cost of glass per square foot: ");
            glassC = askQuestions("What is the cost of glass per square foot: ");
            firstParam = true;
            }
            //System.out.print("What is the cost of trim per linear foot: ");
            trimC = askQuestions("What is the cost of trim per linear foot: ");
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
        float number;
        int numWin = 0;
        boolean isANum = false;
        do{
           try{
           //System.out.print("How many windows will be installed: ");
            number = askQuestions("How many windows will be installed: ");
            //TESTSystem.out.println("The number of windows is number: "+number);
            numWin = (int)number;
            //TESTSystem.out.println("The number of windows after conversion "+numWin);
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
