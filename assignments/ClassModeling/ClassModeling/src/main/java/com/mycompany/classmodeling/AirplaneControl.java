/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmodeling;

/**
 *
 * @author John
 */
public class AirplaneControl {
    private int landingStripNumber;
    private boolean landingStripOpen;
    private Weather weather;

    public void setLandingStripNumber(int landingStripNumber) {
        this.landingStripNumber = landingStripNumber;
    }

    public void setLandingStripOpen(boolean landingStripOpen) {
        this.landingStripOpen = landingStripOpen;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public int getLandingStripNumber() {
        return landingStripNumber;
    }

    public boolean isLandingStripOpen() {
        return landingStripOpen;
    }
  
    public Weather getWeather() {
        return weather;
    }
    
}
