/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.repositories;

import com.powerplantservice.entities.AnnualGenerationByLocationViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mostafa Kashif
 */
public interface  AnnualGenerationByLocationViewRepository extends JpaRepository<AnnualGenerationByLocationViewEntity, String> {
    
}
