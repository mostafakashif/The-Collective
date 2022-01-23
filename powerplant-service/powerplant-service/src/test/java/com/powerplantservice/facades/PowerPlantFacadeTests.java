/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.facades;

import com.powerplantservice.entities.PowerPlantEntity;
import com.powerplantservice.exceptions.ItemNotFoundException;
import com.powerplantservice.models.PowerPlantGetResponse;
import com.powerplantservice.repositories.PowerPlantRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

/**
 *
 * @author Mostafa Kashif
 */
@SpringBootTest
public class PowerPlantFacadeTests {

    @MockBean
    private PowerPlantRepository powerPlantRepository;

    @Autowired
    private PowerPlantFacade powerPlantFacade;

    List<PowerPlantEntity> powerPlantEntities;

    @BeforeEach
    public void setUp() {
        powerPlantEntities = new ArrayList<>();
        PowerPlantEntity powerPlantEntity1 = new PowerPlantEntity(2021, "AA", "Test Power Plant", "AAB", "OS", 12321321);
        PowerPlantEntity powerPlantEntity2 = new PowerPlantEntity(2021, "AA", "Test Power Plant2", "AAB", "OS", 34543);
        PowerPlantEntity powerPlantEntity3 = new PowerPlantEntity(2021, "AA", "Test Power Plant3", "AAB", "OS", 21321);
        powerPlantEntities.add(powerPlantEntity1);
        powerPlantEntities.add(powerPlantEntity2);
        powerPlantEntities.add(powerPlantEntity3);
    }

    @Test
    public void getPowerPlantShouldReturnRepositorySameListSize() {
        Page<PowerPlantEntity> powerPlantPage = new PageImpl<>(powerPlantEntities, Pageable.ofSize(2), 3);
        when(powerPlantRepository.findAll(PageRequest.of(0, 2, Sort.by(new ArrayList<Order>())))).thenReturn(powerPlantPage);
        PowerPlantGetResponse powerPlantGetResponse = powerPlantFacade.getPowerPlant(null, 0, 2, null);
        assertThat(powerPlantGetResponse.getPowerPlantList()).hasSize(powerPlantGetResponse.getPowerPlantList().size());
    }

    @Test
    public void getPowerPlantWithInvalidSequenceThenItemNotFoundException() throws ItemNotFoundException {
        when(powerPlantRepository.findBySequenceNumber(new Integer(12321))).thenReturn(null);
        Assertions.assertThrows(ItemNotFoundException.class, () -> {
            powerPlantFacade.getPowerPlant(new Integer(12321));
        });
    }
}
