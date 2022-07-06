/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dvdorganizer.dao;

import com.mycompany.dvdorganizer.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class DVDOrgDaoFileImp implements DVDOrgDao{
    private static final String RACK_FILE = "rack.txt";
    private static final String DELIMITER = "::";
    
    private Map<String, DVD> dvdRack = new HashMap<>();
 //USE CASE 1 - ADD
    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDOrgDaoException{
        loadRack();
        //prevDVD as after it is added it is the previous
        DVD prevDVD = dvdRack.put(title, dvd);
        writeRack();
        return prevDVD;
    }
//USE CASE 2 - REMOVE
    @Override
    public DVD removeDVD(String title) throws DVDOrgDaoException{
        loadRack();
        DVD toRemove = dvdRack.remove(title);
        writeRack();
        return toRemove;
    }
//USE CASE 3 - EDIT
    @Override
    public DVD editDVD(String title) throws DVDOrgDaoException{
        loadRack();
        DVD editedDVD = dvdRack.get(title);
        writeRack();
        return editedDVD;
    }
//USE CASE 4 - LIST ALL
    @Override
    public Collection<DVD> listAllDVD() throws DVDOrgDaoException{
        loadRack();
        Collection<DVD> yourCollection = dvdRack.values();
        return yourCollection;
    }
//USE CASE 5 - VIEW SINGLE RECORD    
    // gets a single DVD from the collection
    @Override
    public DVD pullDVD(String title) throws DVDOrgDaoException{
        loadRack();
        return dvdRack.get(title);
    }
//USE CASE 6 - SEARCH
    @Override
    public boolean searchRack(String title) throws DVDOrgDaoException{
        loadRack();
        boolean isPresent = dvdRack.containsKey(title);
        return isPresent;
    }
//USE CASE 7 - UNMARSHALL FROM FILE
    private DVD dvdFromFile(String asText){
        String[] dvdInfo = asText.split(DELIMITER);
        String title = dvdInfo[0];
        DVD fromFile = new DVD(title);
        fromFile.setReDate(dvdInfo[1]);
        fromFile.setRating(dvdInfo[2]);
        fromFile.setDir(dvdInfo[3]);
        fromFile.setStudio(dvdInfo[4]);
        fromFile.setUserNote(dvdInfo[5]);
        
        return fromFile;
    }
    //Loads rack from file
    private void loadRack() throws DVDOrgDaoException{
        Scanner scan;
        try{
            //scan from file
            scan = new Scanner(new BufferedReader(new FileReader(RACK_FILE)));
        }catch(FileNotFoundException e){
            throw new DVDOrgDaoException("Failed to load rack into memory", e);
        }
        //Hold line just read from file
        String fileLine;
        DVD currDVD;
        //While the file has a next line to read
        while(scan.hasNextLine()){
            fileLine = scan.nextLine();
            currDVD = dvdFromFile(fileLine);
            dvdRack.put(currDVD.getTitle(), currDVD);
        }
       scan.close();
    }
//USE CASE 8 - MARSHALL TO FILE
    private String dvdToFile(DVD dvd){
        String dvdToText = dvd.getTitle()+DELIMITER+dvd.getReDate()+DELIMITER+
                dvd.getRating()+DELIMITER+dvd.getDir()+DELIMITER+dvd.getStudio()
                +DELIMITER+dvd.getUserNote();
        return dvdToText;
    }
    //writes the rack to file
    private void writeRack()throws DVDOrgDaoException{
        PrintWriter toFile;
        try{
            toFile = new PrintWriter(new FileWriter(RACK_FILE));     
        //catch block translate the IO exception into an application specifi    
        }catch(IOException e){
            throw new DVDOrgDaoException("Unable to write rack to file", e);
        }
        Iterator<DVD> iterate = dvdRack.values().iterator();
        String asText = dvdToFile(iterate.next());
        toFile.println(asText);
        //push buffer to file
        toFile.flush();
        toFile.close();
    }
    

}
