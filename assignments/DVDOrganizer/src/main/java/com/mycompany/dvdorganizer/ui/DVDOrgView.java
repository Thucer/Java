/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dvdorganizer.ui;

import com.mycompany.dvdorganizer.dao.DVDOrgDao;
import com.mycompany.dvdorganizer.dao.DVDOrgDaoFileImp;
import com.mycompany.dvdorganizer.dto.DVD;
import java.util.Collection;

/**
 *
 * @author John
 */
public class DVDOrgView {
    private UserIO io; //= new UserIOConsoleImp();
    private DVDOrgDao dao;// = new DVDOrgDaoFileImp();
    public DVDOrgView(UserIO io, DVDOrgDao dao){
        this.io = io;
        this.dao = dao;
    }
    
    public int getMenuOption(){
        io.print("MAIN MENU");
        io.print("1. Add DVD to rack");
        io.print("2. Remove DVD from rack");
        io.print("3. Edit DVD info");
        io.print("4. List all DVDs on rack");
        io.print("5. Display single DVD info");
        io.print("6. Search");
        io.print("7. Load rack from file");
        io.print("8. Save rack to file");
        io.print("9. Exit");

        return io.readInt("Please make a choice from the menu.", 1, 9);
    }
    //Utilized in multiple use cases
    //gets the title of the DVD to pull from rack
    public String getDVDTitle(){
        return io.readString("Enter the title of the DVD you'd like to view");
    }
    //USE CASE 1
    public DVD addDVDToRack(){
        String dvdTitle = io.readString("Please enter the title of the DVD"),
                dvdReDate = io.readString("Pleae enter the relase date"),
                dvdRating = io.readString("Please enter the DVD rating"),
                dvdDirector = io.readString("Please enter the director"),
                dvdStudio = io.readString("Which studio produced the project"),
                dvdComments = io.readString("Please enter any comments you'd "
                        + "like to share");
        //this current DVD
        DVD currDVD = new DVD(dvdTitle);
        currDVD.setReDate(dvdReDate);
        currDVD.setRating(dvdRating);
        currDVD.setDir(dvdDirector);
        currDVD.setStudio(dvdStudio);
        currDVD.setUserNote(dvdComments);
        
        return currDVD;
    }
    //USE CASE 2
    public void removeDVD(DVD dvd){
        if(dvd != null){
            io.print(dvd.getTitle()+" has been removed from the rack");
        }else{
            io.print("No DVDs on the rack match that title");
        }
        //return dvd;
        dispRemoveDVDSuccessBanner();
    }
    //USE CASE 3
    public DVD editDVD(DVD dvd){
        if(dvd != null){
            io.print(dvd.getTitle()+" is ready to edit.");
            String dvdReDate = io.readString("Pleae enter the relase date"),
                dvdRating = io.readString("Please enter the DVD rating"),
                dvdDirector = io.readString("Please enter the director"),
                dvdStudio = io.readString("Which studio produced the project"),
                dvdComments = io.readString("Please enter any comments you'd "
                        + "like to share");
                //Places new info into the DVD object
                dvd.setReDate(dvdReDate);
                dvd.setRating(dvdRating);
                dvd.setDir(dvdDirector);
                dvd.setStudio(dvdStudio);
                dvd.setUserNote(dvdComments);
                        
        }else{
            io.print("No DVDs on the rack match that title");
        }
        return dvd;
    }
    //USE CASE 4
    public void dispDVDCollection(Collection<DVD> dvdRack){
        //Iterator rackIterate = dvdRack.iterator();
        for(DVD thisDVD : dvdRack){
            String dvdInfo = String.format("Title: %s ->\n  Release Date: %s "
                    + "Rating: %s \n  Director: %s Studio: %s \n  "
                    + "Comments: %s ",
                    thisDVD.getTitle(), thisDVD.getReDate(),
                    thisDVD.getRating(), thisDVD.getDir(),
                    thisDVD.getStudio(), thisDVD.getUserNote());
            io.print(dvdInfo);
        }
    }
    //USE CASE 5
    public void dispDVD(DVD thisDVD){
        if(thisDVD != null){
            String dvdInfo = String.format("Title: %s ->\n  Release Date: %s "
                    + "Rating: %s \n  Director: %s Studio: %s \n  "
                    + "Comments: %s ",
                    thisDVD.getTitle(), thisDVD.getReDate(),
                    thisDVD.getRating(), thisDVD.getDir(),
                    thisDVD.getStudio(), thisDVD.getUserNote());
            io.print(dvdInfo);
        }else{
            io.print("Looks like you don't have that DVD");
        }
    }
    //USE CASE 6 - SEARCH
    public void searchRack(boolean isPresent){
        if(isPresent){
            io.print("Here it is\n");
        }else{
            io.print("That DVD is not on the rack");
        }
        
    }
    //USE CASE 7
    //USE CASE 8
    //USE CASE 9
    
/**
 * This section contains all the methods that display some text Banner
 */  
//USE CASE 1
public void dispAddDVDBanner(){
    io.print("---->ADD TO RACK<----");
}    
public void dispAddSuccessBanner(){
    io.readString("DVD placed on rack. Press enter to continue");
}
//USE CASE 2
public void dispRemoveDVDBanner(){
    io.print("---->REMOVE DVD<----");
}
public void dispRemoveDVDSuccessBanner(){
    io.readString("Press enter to continue");
}
//USE CASE 3
public void dispEditDVDBanner(){
    io.print("---->EDIT DVD<----");
}
public void dispEditDVDSuccessBanner(){
    io.readString("DVD edited, press enter to continue");
}
//USE CASE 4
public void dispEntireCollectionBanner(){
    io.print("---->DVD COLLECTION<----");
}
public void dispCollectionSuccessBanner(){
    io.readString("Those are all the DVDs on the rack. Press enter to continue");
}
//USE CASE 5
public void dispDVDBanner(){
    io.print("--->DVD<---");
}
public void dispDVDSuccessBanner(){
    io.readString("Press enter to continue");
}
//USE CASE 6
public void dispSearchRackBanner(){
    io.print("---->SEARCH<----");
}
public void dispSearchSuccessBanner(){
    io.readString("Press enter to continue");
}
//USE CASE 7
//USE CASE 8
//USE CASE 9 - EXIT
public void dispExitBanner(){
    io.print("Goodbye.");
}
//UNKNOW ENTRY
public void dispUnrecognizedCommandBanner(){
    io.print("You have entered an unrecognized command.");
}
//ERROR
public void dispErrorMsg(String eMsg){
    io.print("--->!ERROR!<---");
    io.print(eMsg);
}
//END VIEW
}
