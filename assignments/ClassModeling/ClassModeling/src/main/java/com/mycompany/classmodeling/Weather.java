/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmodeling;

/**
 *
 * @author John
 */
class Weather {
    private float windSpeed;
    private float temperature;
    private boolean precipitation;

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setPrecipitation(boolean precipitation) {
        this.precipitation = precipitation;
    }
    public float getWindSpeed() {
        return windSpeed;
    }

    public float getTemperature() {
        return temperature;
    }

    public boolean isPrecipitation() {
        return precipitation;
    }
    //method takes 3 parameters and evaluates whether the weather is good
    // returns a boolean value
    public boolean checkWeather(float wSpeed, float temperature, boolean precipitation){
        boolean isGood = false;
        //if statement to evaluate whether parameters fall in 
        //acceptable bounds
        
        return isGood;
    }
}
