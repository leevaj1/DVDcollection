/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionn;

import com.mycompany.dvdcollectionn.DvdController.DvdController;
import com.mycompany.dvdcollectionn.DvdList.dao.DvdListDao;
import com.mycompany.dvdcollectionn.DvdList.dao.DvdListDaoFileImpl;
import com.mycompany.dvdcollectionn.DvdList.ui.DvdListView;
import com.mycompany.dvdcollectionn.DvdList.ui.UserIO;
import com.mycompany.dvdcollectionn.DvdList.ui.UserIOConsoleImpl;

/**
 *
 * @author leeva
 */
public class App1 {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdListView myView = new DvdListView(myIo);
        DvdListDao myDao = new DvdListDaoFileImpl();
        DvdController controller
                = new DvdController(myDao, myView);
        controller.run();
    }
}
