/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmodeling;

/**
 *
 * @author John
 */
public class HouseGps {
        private float longitude, latitude;
        private String address;

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        public float getLongitude() {
            return longitude;
        }

        public float getLatitude() {
            return latitude;
        }

        public String getAddress() {
            return address;
        }  
}
