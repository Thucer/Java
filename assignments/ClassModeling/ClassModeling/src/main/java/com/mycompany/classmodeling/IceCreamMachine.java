/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmodeling;

/**
 *
 * @author John
 */
public class IceCreamMachine {
    private float temperature, sugarOunces, milkOunces;
    private boolean inRange;
    //could also create a read only value 'ratio' which would define the correct
    //milk to sugar ratio.
    
    //method checks whether temp is in range and sugar and milk ratio is right
    public boolean checkRange(){
        //if statement with && operator
        return inRange;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getSugarOunces() {
        return sugarOunces;
    }

    public float getMilkOunces() {
        return milkOunces;
    }

    public boolean isInRange() {
        return inRange;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setSugarOunces(float sugarOunces) {
        this.sugarOunces = sugarOunces;
    }

    public void setMilkOunces(float milkOunces) {
        this.milkOunces = milkOunces;
    }

    public void setInRange(boolean inRange) {
        this.inRange = inRange;
    }
    
}
