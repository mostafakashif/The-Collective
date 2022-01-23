/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.models;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mostafa Kashif
 */
public class PowerPlantGetResponse implements Serializable {

    private List<PowerPlantDTO> powerPlantList;

    private int totalNumberOfPages;

    private long totalNumberOfElements;

    private int curentPageNumberOfElements;
    
    private int curentPageNumber;

    public PowerPlantGetResponse() {
    }

    public List<PowerPlantDTO> getPowerPlantList() {
        return powerPlantList;
    }

    public void setPowerPlantList(List<PowerPlantDTO> powerPlantList) {
        this.powerPlantList = powerPlantList;
    }

    public int getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    public void setTotalNumberOfPages(int totalNumberOfPages) {
        this.totalNumberOfPages = totalNumberOfPages;
    }

    public long getTotalNumberOfElements() {
        return totalNumberOfElements;
    }

    public void setTotalNumberOfElements(long totalNumberOfElements) {
        this.totalNumberOfElements = totalNumberOfElements;
    }

    public int getCurentPageNumberOfElements() {
        return curentPageNumberOfElements;
    }

    public void setCurentPageNumberOfElements(int curentPageNumberOfElements) {
        this.curentPageNumberOfElements = curentPageNumberOfElements;
    }

    public int getCurentPageNumber() {
        return curentPageNumber;
    }

    public void setCurentPageNumber(int curentPageNumber) {
        this.curentPageNumber = curentPageNumber;
    }

    
}
