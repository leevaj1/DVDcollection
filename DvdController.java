/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionn.DvdController;

import com.mycompany.dvdcollectionn.DvdList.dao.DvdListDao;
import com.mycompany.dvdcollectionn.DvdList.dao.DvdListDaoException;
import com.mycompany.dvdcollectionn.DvdList.dto.Dvd;
import com.mycompany.dvdcollectionn.DvdList.ui.DvdListView;
import java.util.List;

/**
 *
 * @author leeva
 */
public class DvdController {

    DvdListView view;
    DvdListDao dao;

    public DvdController(DvdListDao myDao, DvdListView myView) {
        this.dao = myDao;
        this.view = myView;

    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvd();
                        break;
                    case 2:
                        addDvd();
                        break;
                    case 3:
                        searchEditDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        displayDvd();
                        break;
//                    case 6:
//                        searchTitle();
//                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DvdListDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDvd() throws DvdListDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvd() throws DvdListDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void searchEditDvd() throws DvdListDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
        //print list so user can see which dvd they want to edit
        String dvdSelection = view.getDvdSelection();
        Dvd dvdToEdit = dao.getDvd(dvdSelection);
        if (dvdToEdit != null) {
            //dvdToEdit = dao.getDvd(dvdSelection);

            int menuSelection = view.getEditSelection();
            String userInput;

            switch (menuSelection) {
//                case 1:
//                    userInput = getUserEditInput();
//                    dvdToEdit.setTitle(userInput);
//                    dao.updateDvd(dvdToEdit);
//                    break;
                case 1:
                    userInput = getUserEditInput();
                    dvdToEdit.setReleaseDate(userInput);
                    dao.updateDvd(dvdToEdit);
                    break;
                case 2:
                    userInput = getUserEditInput();
                    dvdToEdit.setMPAARating(userInput);
                    dao.updateDvd(dvdToEdit);
                    break;
                case 3:
                    userInput = getUserEditInput();
                    dvdToEdit.setDirectorName(userInput);
                    dao.updateDvd(dvdToEdit);
                    break;
                case 4:
                    userInput = getUserEditInput();
                    dvdToEdit.setStudio(userInput);
                    dao.updateDvd(dvdToEdit);
                    break;
                case 5:
                    userInput = getUserEditInput();
                    dvdToEdit.setUserRating(userInput);
                    dao.updateDvd(dvdToEdit);
                    break;
            }
        }
    }

    private String getUserEditInput() {
        return view.getUserEditInput();
    }

    private void removeDvd() throws DvdListDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
        view.displayRemoveDvdBanner();
        String Dvd = view.getDvdChoice();
        dao.removeDvd(Dvd);
        view.displayRemoveSuccessBanner();
    }

    private void displayDvd() throws DvdListDaoException {
        view.displayDisplayDvdBanner();
        String Dvd = view.getDvdChoice();
        Dvd dvd = dao.getDvd(Dvd);
        view.displayDvd(dvd);

    }

    private void searchTitle() throws DvdListDaoException {
        view.displayDisplayDvdBanner();
        String Dvd = view.getDvdChoice();
        Dvd dvd = dao.getDvd(Dvd);
        view.displayDvd(dvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    /**
     *
     * @param dao
     * @param view
     */
}
