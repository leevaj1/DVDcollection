/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionn.DvdList.dto;

/**
 *
 * @author leeva
 */
public class Dvd {

    private String title;
    private String releaseDate;
    private String mPAARating;
    private String directorName;
    private String studio;
    private String userRating;// Java or .Net + cohort month/year

    public Dvd(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return getmPAARating();
    }

    public void setMPAARating(String mPAARating) {
        this.mPAARating = mPAARating;
    }

    public String getDirectorName() {
        return directorName;

    }

    public void setDirectorName(String directorName) {

        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public String getmPAARating() {
        return mPAARating;
    }

    /**
     * @param dvd the dvd to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param mPAARating the mPAARating to set
     */
    public void setmPAARating(String mPAARating) {
        this.mPAARating = mPAARating;
    }


}
