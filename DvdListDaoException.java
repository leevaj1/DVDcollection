/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionn.DvdList.dao;

/**
 *
 * @author leeva
 */
public class DvdListDaoException extends Exception {
        public DvdListDaoException(String message) {
        super(message);
    }

    public DvdListDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
