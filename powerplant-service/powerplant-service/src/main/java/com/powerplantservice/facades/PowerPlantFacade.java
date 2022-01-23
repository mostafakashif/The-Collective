/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.facades;

import com.powerplantservice.entities.PowerPlantEntity;
import com.powerplantservice.exceptions.ItemNotFoundException;
import com.powerplantservice.mappers.PowerPlantMapper;
import com.powerplantservice.models.AnnualGenerationByLocationResponse;
import com.powerplantservice.models.PowerPlantDTO;
import com.powerplantservice.models.PowerPlantGetResponse;
import com.powerplantservice.repositories.PowerPlantRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;
import com.powerplantservice.repositories.AnnualGenerationByLocationViewRepository;
import org.springframework.data.mapping.PropertyReferenceException;

/**
 *
 * @author Mostafa Kashif
 */
@Component
public class PowerPlantFacade {

    @Autowired
    private PowerPlantRepository powerPlantRepository;

    @Autowired
    private AnnualGenerationByLocationViewRepository annualGenerationByLocationViewRepository;

    @Autowired
    private PowerPlantMapper powerPlantMapper;

    @Value("${maxPageSize}")
    private Integer maxPageSize;

    public PowerPlantGetResponse getPowerPlant(String stateLocationCode, Integer pageNumber, Integer pageSize, List<String> sortList) {
        try {
            Page<PowerPlantEntity> powerPlantEntityPage;
            PowerPlantGetResponse powerPlantGetResponse = new PowerPlantGetResponse();
            List<Order> orders = new ArrayList<>();
            if (pageSize == null) {
                pageSize = maxPageSize;
            }
            if (pageSize > maxPageSize) {
                throw new IllegalArgumentException("Page size should not exceed:" + maxPageSize);
            }
            if (pageNumber == null) {
                pageNumber = 0;
            }
            if (sortList != null && sortList.size() > 0) {
                for (String sortString : sortList) {
                    if (sortString == null || sortString.isEmpty() || sortString.split(";").length != 2 || (!sortString.split(";")[1].equalsIgnoreCase("asc") && !sortString.split(";")[1].equalsIgnoreCase("desc"))) {
                        throw new IllegalArgumentException("Sort should be in this format propertyName;direction.Direction to be asc or desc");
                    }
                }
                try {
                    sortList.forEach(sort -> {
                        orders.add(new Order(sort.split(";")[1].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sort.split(";")[0]));
                    });
                } catch (PropertyReferenceException propertyReferenceException) {
                    throw new IllegalArgumentException("Invalid Sort Column:" + propertyReferenceException.getPropertyName());
                }
            }

            if (stateLocationCode != null) {
                powerPlantEntityPage = powerPlantRepository.findByStateLocationCode(stateLocationCode, PageRequest.of(pageNumber, pageSize, Sort.by(orders)));
            } else {
                powerPlantEntityPage = powerPlantRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(orders)));
            }
            powerPlantGetResponse.setPowerPlantList(powerPlantMapper.convertPowerPlantEntityListToDTOList(powerPlantEntityPage.getContent()));
            powerPlantGetResponse.setTotalNumberOfElements(powerPlantEntityPage.getTotalElements());
            powerPlantGetResponse.setTotalNumberOfPages(powerPlantEntityPage.getTotalPages());
            powerPlantGetResponse.setCurentPageNumberOfElements(powerPlantEntityPage.getNumberOfElements());
            powerPlantGetResponse.setCurentPageNumber(powerPlantEntityPage.getNumber());
            return powerPlantGetResponse;
        } catch (PropertyReferenceException propertyReferenceException) {
            throw new IllegalArgumentException("Invalid Sort Property Name: '" + propertyReferenceException.getPropertyName()+"'");
        }

    }

    public PowerPlantDTO getPowerPlant(Integer sequenceNumber) throws ItemNotFoundException {
        PowerPlantEntity powerPlantEntity = powerPlantRepository.findBySequenceNumber(sequenceNumber);
        if (powerPlantEntity != null) {
            return powerPlantMapper.convertPowerPlantEntityToDTO(powerPlantEntity);
        } else {
            throw new ItemNotFoundException();
        }
    }

    public List<AnnualGenerationByLocationResponse> getPowerPlantGenerationSummary() {
        return powerPlantMapper.convertAnnaulGenerationEntityListToDTOList(annualGenerationByLocationViewRepository.findAll());
    }
}
