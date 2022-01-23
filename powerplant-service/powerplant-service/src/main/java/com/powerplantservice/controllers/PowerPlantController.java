/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.controllers;

import com.powerplantservice.exceptions.ItemNotFoundException;
import com.powerplantservice.facades.PowerPlantFacade;
import com.powerplantservice.models.AnnualGenerationByLocationResponse;
import com.powerplantservice.models.ErrorModel;
import com.powerplantservice.models.PowerPlantDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Mostafa Kashif
 */
@RestController
public class PowerPlantController {

    @Autowired
    private PowerPlantFacade powerPlantFacade;

    @GetMapping("/powerplants")
    public ResponseEntity<?> getPowerPlant(@RequestParam(required = false) String locationCode, @RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize, @RequestParam(required = false) List<String> sort) {
        try {
            return new ResponseEntity<>(powerPlantFacade.getPowerPlant(locationCode, pageNumber, pageSize, sort),HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(
                    new ErrorModel(illegalArgumentException.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/powerplants/{sequenceNumber}")
    public PowerPlantDTO getPowerPlant(@PathVariable Integer sequenceNumber) {
        try {
            return powerPlantFacade.getPowerPlant(sequenceNumber);
        } catch (ItemNotFoundException itemNotFoundException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/powerplant-generationsummay")
    public List<AnnualGenerationByLocationResponse> getPowerPlantGenerationSummary() {
        return powerPlantFacade.getPowerPlantGenerationSummary();
    }
}
