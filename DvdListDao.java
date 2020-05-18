package com.mycompany.dvdcollectionn.DvdList.dao;

import com.mycompany.dvdcollectionn.DvdList.dto.Dvd;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leeva
 */
public interface DvdListDao {

    /**
     * Adds the given Student to the roster and associates it with the given
     * student id. If there is already a student associated with the given
     * student id it will return that student object, otherwise it will return
     * null.
     *
     * @param dvdTitle id with which student is to be associated
     * @param dvd dvd to be added to the roster
     * @return the dvd object previously associated with the given student id if
     * it exists, null otherwise
     * @throws com.mycompany.dvdcollectionn.DvdList.dao.DvdListDaoException
     *
     */
    Dvd addDvd(String dvdTitle, Dvd dvd)
            throws DvdListDaoException;
    
    void updateDvd(Dvd updatedDvd)
            throws DvdListDaoException;

    List<Dvd> getAllDvds()
            throws DvdListDaoException;

    /**
     * Returns the student object associated with the given student id. Returns
     * null if no such student exists
     *
     * @param dvdTitle ID of the student to retrieve
     * @return the Student object associated with the given student id, null if
     * no such student exists
     * @throws com.mycompany.dvdcollectionn.DvdList.dao.DvdListDaoException
     *
     */
    Dvd getDvd(String dvdTitle)
            throws DvdListDaoException;

    /**
     * Removes from the roster the student associated with the given id. Returns
     * the student object that is being removed or null if there is no student
     * associated with the given id
     *
     * @param dvdTitle id of dvd to be removed
     * @return Student object that was removed or null if no student was
     * associated with the given student id
     * @throws com.mycompany.dvdcollectionn.DvdList.dao.DvdListDaoException
     *
     *
     */
    Dvd removeDvd(String dvdTitle)
            throws DvdListDaoException;



}
