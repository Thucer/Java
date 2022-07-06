/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dvdorganizer.dao;

/**
 *
 * @author John
 */
public class DVDOrgDaoException extends Exception{
    
    public DVDOrgDaoException(String msg){
        super(msg);
    }
    public DVDOrgDaoException(String msg, Throwable cause){
        super(msg, cause);
    }
}
