/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmodeling;

/**
 *
 * @author John
 */
public class IceCreamInventory {
    private String packageDate, brand;
    private int number;
    
    public boolean checkDate(String date){
        boolean goneBad = false;
        //If statement comparing the pacakge date to today
        return goneBad;
    }

    public void setPackageDate(String packageDate) {
        this.packageDate = packageDate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPackageDate() {
        return packageDate;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }
    
}
