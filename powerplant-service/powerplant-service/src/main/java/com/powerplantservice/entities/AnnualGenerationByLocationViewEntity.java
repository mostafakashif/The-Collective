/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mostafa Kashif
 */
@Entity
@Table(name = "annual_generation_by_Location")
public class AnnualGenerationByLocationViewEntity implements Serializable {

    @Id
    @Column(name = "locationCode")
    private String locationCode;

    @Column(name = "locationGeneratorAnnualSum")
    private Long locationGeneratorAnnualSum;

    @Column(name = "locationGeneratorAnnualPercentage")
    private Double locationGeneratorAnnualPercentage;

    public Long getLocationGeneratorAnnualSum() {
        return locationGeneratorAnnualSum;
    }

    public void setLocationGeneratorAnnualSum(Long locationGeneratorAnnualSum) {
        this.locationGeneratorAnnualSum = locationGeneratorAnnualSum;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public Double getLocationGeneratorAnnualPercentage() {
        return locationGeneratorAnnualPercentage;
    }

    public void setLocationGeneratorAnnualPercentage(Double locationGeneratorAnnualPercentage) {
        this.locationGeneratorAnnualPercentage = locationGeneratorAnnualPercentage;
    }

}
