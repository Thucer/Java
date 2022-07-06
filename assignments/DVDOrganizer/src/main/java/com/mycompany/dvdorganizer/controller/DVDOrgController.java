/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dvdorganizer.controller;

import com.mycompany.dvdorganizer.dao.DVDOrgDao;
import com.mycompany.dvdorganizer.dao.DVDOrgDaoException;
import com.mycompany.dvdorganizer.dao.DVDOrgDaoFileImp;
import com.mycompany.dvdorganizer.dto.DVD;
import com.mycompany.dvdorganizer.ui.DVDOrgView;
import com.mycompany.dvdorganizer.ui.UserIO;
import com.mycompany.dvdorganizer.ui.UserIOConsoleImp;
import java.util.Collection;

/**
 * stores dvds in collection called rack
 * @author John
 */
public class DVDOrgController {
    //UserIO is the Service class used by DVDOrgController, it is a dependency
    //of this class
    private UserIO io = new UserIOConsoleImp();
    private DVDOrgView view; //= new DVDOrgView();
    private DVDOrgDao dao; //= new DVDOrgDaoFileImp();
    public DVDOrgController(DVDOrgView view, DVDOrgDao dao){
        this.view = view;
        this.dao = dao;
    }
    public void runApp(){
        boolean runApp = true;
        try{    
            while(runApp){

                int menuOption = getMenuChoice();

                switch(menuOption){
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listCollection();
                        break;
                    case 5:
                        listDVD();
                        break;
                    case 6:
                        searchRack();
                        break;
                    case 7:
                        io.print("LOAD");
                        break;
                    case 8:
                        io.print("SAVE");
                        break;
                    case 9:
                        runApp = false;
                        break;
                    default :
                        unrecognizedEntry();
                //END SWITCH    
                }
            //END WHILE
            }closeApp();
        //END TRY
        }catch(DVDOrgDaoException e){
            //makes a call to super to getMessage?
            view.dispErrorMsg(e.getMessage());
        }
    //END RUNAPP    
    }
    private int getMenuChoice(){
        return view.getMenuOption();
    }
    //USE CASE 1 - ADD
    private void addDVD()throws DVDOrgDaoException{
        view.dispAddDVDBanner();
        DVD newDVD = view.addDVDToRack();
        //calls add method in the dao classimpl
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.dispAddSuccessBanner();
    }
    //USE CASE 2 - REMOVE
    private void removeDVD()throws DVDOrgDaoException{
        view.dispRemoveDVDBanner();
        String title = view.getDVDTitle();
        DVD toRemove = dao.removeDVD(title);
        view.removeDVD(toRemove);
    }
    //USE CASE 3 - EDIT
    private void editDVD()throws DVDOrgDaoException{
        view.dispEditDVDBanner();
        //gets title of DVD to edit
        String title = view.getDVDTitle();
        DVD toEdit = dao.editDVD(title);
        view.editDVD(toEdit);
        view.dispEditDVDSuccessBanner();
        
    }
    //USE CASE 4 - LIST ALL
    private void listCollection()throws DVDOrgDaoException{
        view.dispEntireCollectionBanner();
       //calls the listAllDVD method in the DAO implementation, this method
       //returns a Collection of DVD object, which is passed on
        view.dispDVDCollection(dao.listAllDVD());
        view.dispCollectionSuccessBanner();
    }
    //USE CASE 5 - SHOW SINGLE RECORD
    private void listDVD()throws DVDOrgDaoException{
        view.dispDVDBanner();
        String title = view.getDVDTitle();
        DVD thisDVD = dao.pullDVD(title);
        view.dispDVD(thisDVD);
        view.dispDVDSuccessBanner();
    }
    //USE CASE 6 - SEARCH
    private void searchRack()throws DVDOrgDaoException{
        view.dispSearchRackBanner();
        String title = view.getDVDTitle();
        boolean isPresent = dao.searchRack(title);
        view.searchRack(isPresent);
        if(isPresent)
            view.dispDVD(dao.pullDVD(title));
    }
    //USE CASE 9 - EXIT
    private void closeApp(){
        view.dispExitBanner();
    }
    //UNKNOWN COMMAND
    private void unrecognizedEntry(){
        view.dispUnrecognizedCommandBanner();
    }
//END CONTROLLER
}
