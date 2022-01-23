/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.repositories;

import com.powerplantservice.entities.PowerPlantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mostafa Kashif
 */
@Repository
public interface PowerPlantRepository extends JpaRepository<PowerPlantEntity, Long> {

    Page<PowerPlantEntity> findByStateLocationCode(String locationCode, Pageable pageable);

    PowerPlantEntity findBySequenceNumber(Integer sequenceNumber);
}
