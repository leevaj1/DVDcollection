/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionn.DvdList.dao;

import com.mycompany.dvdcollectionn.DvdList.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leeva
 */
public class DvdListDaoFileImpl implements DvdListDao {

    private final Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String title, Dvd dvd)
            throws DvdListDaoException {
        Dvd newDvd = dvds.put(title, dvd);
        try {
            writeRoster();
        } catch (IOException ex) {
            //TODO: translate these exceptions into a more common one (PersistenceException)
            
            
            //Logger.getLogger(DvdListDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newDvd;
    }
    
    @Override
    public void updateDvd(Dvd updatedDvd) throws DvdListDaoException{
        Dvd newDvd = dvds.put(updatedDvd.getTitle() ,updatedDvd);
        try{
        writeRoster();
        } catch(IOException e){
            Logger.getLogger(DvdListDaoFileImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
    }

    @Override
    public List<Dvd> getAllDvds()
            throws DvdListDaoException {
        loadRoster();
        return new ArrayList<>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title)
            throws DvdListDaoException {
        loadRoster();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title)
            throws DvdListDaoException {
        Dvd removedDvd = dvds.remove(title);
        try {
            writeRoster();
        } catch (IOException ex) {
            Logger.getLogger(DvdListDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return removedDvd;
    }
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private void loadRoster() throws DvdListDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdListDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens holds each of the parts of the currentLine after it has
        // been split on our DELIMITER
        // NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
        // currentLine looks like this:
        // 1234::Joe::Smith::Java-September2013
        // then currentTokens will be a string array that looks like this:
        //
        // ___________________________________
        // |    |   |     |                  |
        // |1234|Joe|Smith|Java-September2013|
        // |    |   |     |                  |
        // -----------------------------------
        //  [0]  [1]  [2]         [3]
        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Student object and put it into the map of students
            // NOTE FOR APPRENTICES: We are going to use the student id
            // which is currentTokens[0] as the map key for our student object.
            // We also have to pass the student id into the Student constructor
            Dvd currentDvd = new Dvd(currentTokens[0]);
            // Set the remaining vlaues on currentStudent manually
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setMPAARating(currentTokens[2]);
            currentDvd.setDirectorName(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserRating(currentTokens[5]);

            // Put currentStudent into the map using studentID as the key
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

 
    private void writeRoster() throws DvdListDaoException, IOException {
  
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DvdListDaoException(
                    "Could not save DVD data.", e);
        }

    
        List<Dvd> dvdList = new ArrayList(dvds.values());
        dvdList.stream().map((Dvd currentDvd) -> {
            // write the Student object to the file
            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getMPAARating() + DELIMITER
                    + currentDvd.getDirectorName() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getUserRating());
            return currentDvd;
        }).forEachOrdered((Dvd _item) -> {
            // force PrintWriter to write line to the file
            out.flush();
        });
        // Clean up
        out.close();
    }

}
