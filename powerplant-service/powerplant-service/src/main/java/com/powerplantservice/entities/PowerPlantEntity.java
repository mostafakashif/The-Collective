/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mostafa Kashif
 */
@Entity
@Table(name = "POWER_PLANT")
public class PowerPlantEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SEQUENCE_NUMBER")
    private Integer sequenceNumber;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "PSTATABB")
    private String stateLocationCode;

    @Column(name = "PNAME")
    private String name;

    @Column(name = "GENID")
    private String generatorId;

    @Column(name = "GENSTAT")
    private String generatorStatus;

    @Column(name = "GENNTAN")
    private Integer generatorAnnualNetGeneration;

    public PowerPlantEntity() {

    }

    public PowerPlantEntity(Integer year, String stateLocationCode, String name, String generatorId, String generatorStatus, Integer generatorAnnualNetGeneration) {
        this.year = year;
        this.stateLocationCode = stateLocationCode;
        this.name = name;
        this.generatorId = generatorId;
        this.generatorStatus = generatorStatus;
        this.generatorAnnualNetGeneration = generatorAnnualNetGeneration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
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
