/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionn.DvdList.ui;

import com.mycompany.dvdcollectionn.DvdList.dto.Dvd;
import java.util.List;

/**
 *
 * @author leeva
 */
public class DvdListView {

    private final UserIO io;

    public DvdListView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Of DVD's");
        io.print("2. Add New Dvd");
        io.print("3. Edit a DVD");
        io.print("4. Remove a DVD");
        io.print("5. View a DVD");
        //io.print("6. Title Search For a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public Dvd getNewDvdInfo() {
        String dvdTitle = io.readString("Please enter a DVD Title");
        String releaseDate = io.readString("Please enter the release date (yyyy)");
        String MPAARating = io.readString("Please enter MPAA rating");
        String directorName = io.readString("Please enter the directors name");
        String studio = io.readString("Please enter a studio");
        String userRating = io.readString("Rate/comment about the movie");
        Dvd currentDvd = new Dvd(dvdTitle);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMPAARating(MPAARating);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        return currentDvd;
    }
    
    public String getDvdSelection(){
        return io.readString("What dvd would you like to edit?");
    }
    
    public int getEditSelection(){
        return io.readInt("What data would you like to change?" + 
                          //"\n(1)Dvd Title" +
                          "\n(1)Release Date" +
                          "\n(2)MPAARating" +
                          "\n(3)Director's Name" +
                          "\n(4)Studio" +
                          "\n(5)Rate/Comment");
    }
    
    public String getUserEditInput(){
        return io.readString("Please Enter The New Change Below!");
    }

    public void displayCreateDvdBanner() {
        io.print("=== Add Your Dvd ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully added.  Please hit enter to continue");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        dvdList.forEach((currentDvd) -> {
            io.print(currentDvd.getTitle() + ": "
                    + currentDvd.getReleaseDate() + " , "
                    + currentDvd.getMPAARating() + " , "
                    + currentDvd.getDirectorName() + " , "
                    + currentDvd.getStudio() + " , "
                    + currentDvd.getUserRating());
        });
        
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Your DVD Library ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Search a DVD ===");
    }

    public String getDvdChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print (dvd.getMPAARating());
            io.print(dvd.getDirectorName());
            io.print (dvd.getStudio());
            io.print (dvd.getUserRating());
            io.print(":");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }


    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    /**
     *
     * @param dvdList
     */





    }



