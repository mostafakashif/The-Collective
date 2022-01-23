/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.mappers;

import com.powerplantservice.entities.AnnualGenerationByLocationViewEntity;
import com.powerplantservice.entities.PowerPlantEntity;
import com.powerplantservice.models.AnnualGenerationByLocationResponse;
import com.powerplantservice.models.PowerPlantDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author Mostafa Kashif
 */
@Mapper(componentModel = "spring")
public interface PowerPlantMapper {

    List<PowerPlantDTO> convertPowerPlantEntityListToDTOList(List<PowerPlantEntity> powerPlantEntity);

    PowerPlantDTO convertPowerPlantEntityToDTO(PowerPlantEntity powerPlantEntity);

    List<AnnualGenerationByLocationResponse> convertAnnaulGenerationEntityListToDTOList(List<AnnualGenerationByLocationViewEntity> annualGenerationByLocationViewEntity);

    AnnualGenerationByLocationResponse convertAnnualGenerationByLocationResponseToDTO(AnnualGenerationByLocationViewEntity annualGenerationByLocationViewEntity);
}
