/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmodeling;

/**
 *
 * @author John
 */
public class CarA {
    private int topSpeed, playerLevel;
    private String name;
    //Constructor used to initialize the read-only values. In a real game this
    //would likely reference a Player class object as well as some type of 
    //car class. Using literals for simplicity here.
    public CarA(){
        playerLevel = 7;
        name = "Zoomer";
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
/*Set methods for these values are ommitted as they are defined by the game and
    are read only.
    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public void setName(String name) {
        this.name = name;
    }
*/
    public int getTopSpeed() {
        return topSpeed;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public String getName() {
        return name;
    }
    
    
}
