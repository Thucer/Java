/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmodeling;

/**
 *
 * @author John
 */
public class HouseDesign {
        private double sqft, length, width, height;
        private int rooms, windows;

        public void setSqft(double sqft) {
            this.sqft = sqft;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public void setRooms(int rooms) {
            this.rooms = rooms;
        }

        public void setWindows(int windows) {
            this.windows = windows;
        }
        public double getSqft() {
            return sqft;
        }

        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        public int getRooms() {
            return rooms;
        }

        public int getWindows() {
            return windows;
        }
    
}
