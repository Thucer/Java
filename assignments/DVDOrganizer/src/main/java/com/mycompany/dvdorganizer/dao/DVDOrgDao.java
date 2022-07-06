/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dvdorganizer.dao;

import com.mycompany.dvdorganizer.dto.DVD;
import java.util.Collection;

/**
 *
 * @author John
 */
public interface DVDOrgDao {
    /**
     * Adds a DVD to the rack and associates it with its title. If there is 
     * already a DVD of that title on the rack it will return that object and 
     * alert the user, otherwise it will return null
     * 
     * Takes two parameters a String title and the DVD object to be placed on
     * the rack. Returns the DVD if already on the rack, null if else
     * @param title is the DVD title with which to associate the DVD object
     * @param dvd is the DVD to be placed on the rack
     * @return the DVD object associated with the title, or null
     */
    DVD addDVD (String title, DVD dvd)throws DVDOrgDaoException;
    /**
     * Removes a the DVD object associated with the given title from the rack
     * Returns the DVD being removed or null if no DVD of the given title
     * is present
     * 
     * @param title is the title of the DVD object being removed
     * @return DVD object being removed or null if none
     */
    DVD removeDVD(String title)throws DVDOrgDaoException;
    /**
     * Edits the info of the DVD object associated with the given title. Returns
     * the edited DVD object or null if there was no object associated with the 
     * give title.
     * 
     * Program parameters were unclear as to whether this method should allow 
     * the user to edit the DVD title. As there were no specific instructions 
     * given this method DOES NOT allow the user to edit the DVD title, if this
     * functionality is desired a constructor call in the editDVD method present
     * in the view layer is necessary.
     *
     * 
     * @param title is the title of the DVD object being edited
     * @return the edited DVD object or null if no DVD of given title existed
     */
    DVD editDVD(String title)throws DVDOrgDaoException;
    /**
     * returns a list of all DVDs present on the rack
     * @return returns a List structure of all the DVDs on the rack
     */
    Collection<DVD> listAllDVD()throws DVDOrgDaoException;
    /**
     * Pulls a DVD object of the given title from the rack for inspection.
     * Returns the DVD object associated with the given title or null if none
     * present
     * @param title is the title of the DVD object
     * @return the DVD object associated with given title or null
     */
    DVD pullDVD(String title)throws DVDOrgDaoException;
    /**
     * Searches through the rack for a particular DVD title, a boolean of true
     * if the DVD is present else returns false
     * 
     * @param title is the title of the DVD and search key
     * @return returns a boolean value, if the searchKey is found it will return
     * true, else false
     */
    boolean searchRack(String title)throws DVDOrgDaoException;
    
}
