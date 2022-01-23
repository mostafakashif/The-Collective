/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.models;

import java.io.Serializable;

/**
 *
 * @author Mostafa Kashif
 */
public class PowerPlantDTO implements Serializable{

    private Long sequenceNumber;

    private Integer year;

    private String stateLocationCode;

    private String name;

    private String generatorId;

    private String generatorStatus;

    private Integer generatorAnnualNetGeneration;

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getStateLocationCode() {
        return stateLocationCode;
    }

    public void setStateLocationCode(String stateLocationCode) {
        this.stateLocationCode = stateLocationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public String getGeneratorStatus() {
        return generatorStatus;
    }

    public void setGeneratorStatus(String generatorStatus) {
        this.generatorStatus = generatorStatus;
    }

    public Integer getGeneratorAnnualNetGeneration() {
        return generatorAnnualNetGeneration;
    }

    public void setGeneratorAnnualNetGeneration(Integer generatorAnnualNetGeneration) {
        this.generatorAnnualNetGeneration = generatorAnnualNetGeneration;
    }
}
