/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.models;

/**
 *
 * @author Mostafa Kashif
 */
public class AnnualGenerationByLocationResponse {

    private String locationCode;

    private Long locationGeneratorAnnualSum;

    private Double locationGeneratorAnnualPercentage;

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public Long getLocationGeneratorAnnualSum() {
        return locationGeneratorAnnualSum;
    }

    public void setLocationGeneratorAnnualSum(Long locationGeneratorAnnualSum) {
        this.locationGeneratorAnnualSum = locationGeneratorAnnualSum;
    }

    public Double getLocationGeneratorAnnualPercentage() {
        return locationGeneratorAnnualPercentage;
    }

    public void setLocationGeneratorAnnualPercentage(Double locationGeneratorAnnualPercentage) {
        this.locationGeneratorAnnualPercentage = locationGeneratorAnnualPercentage;
    }

}
