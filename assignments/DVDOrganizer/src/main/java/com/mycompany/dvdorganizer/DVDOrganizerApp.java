/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.dvdorganizer;

import com.mycompany.dvdorganizer.controller.DVDOrgController;
import com.mycompany.dvdorganizer.dao.DVDOrgDao;
import com.mycompany.dvdorganizer.dao.DVDOrgDaoFileImp;
import com.mycompany.dvdorganizer.ui.DVDOrgView;
import com.mycompany.dvdorganizer.ui.UserIO;
import com.mycompany.dvdorganizer.ui.UserIOConsoleImp;

/**
 *
 * @author John
 */
public class DVDOrganizerApp {
    
 //EXECUTION   
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImp();
        DVDOrgDao dao = new DVDOrgDaoFileImp();
        DVDOrgView view = new DVDOrgView(io,dao);
        DVDOrgController run = new DVDOrgController(view, dao);
        run.runApp();
    }


//END
}
