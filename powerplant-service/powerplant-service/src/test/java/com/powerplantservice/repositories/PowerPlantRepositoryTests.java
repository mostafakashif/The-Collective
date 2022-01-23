/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.repositories;

import com.powerplantservice.entities.PowerPlantEntity;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Mostafa Kashif
 */
@DataJpaTest
public class PowerPlantRepositoryTests {

    @Autowired
    private PowerPlantRepository powerPlantRepository;

    @Test
    public void should_find_all_powerplants() {
        PowerPlantEntity powerPlantEntity1 = powerPlantRepository.save(new PowerPlantEntity(2021, "AA", "Test Power Plant", "AAB", "OS", 12321321));
        powerPlantRepository.save(powerPlantEntity1);

        PowerPlantEntity powerPlantEntity2 = powerPlantRepository.save(new PowerPlantEntity(2021, "AA", "Test Power Plant2", "AAB", "OS", 34543));
        powerPlantRepository.save(powerPlantEntity2);

        PowerPlantEntity powerPlantEntity3 = powerPlantRepository.save(new PowerPlantEntity(2021, "AA", "Test Power Plant3", "AAB", "OS", 21321));
        powerPlantRepository.save(powerPlantEntity3);

        List<PowerPlantEntity> powerPlantEntities = powerPlantRepository.findAll();

        assertThat(powerPlantEntities).hasSize(3);
    }

    @Test
    public void should_return_first_page() {
        PowerPlantEntity powerPlantEntity1 = powerPlantRepository.save(new PowerPlantEntity(2021, "AA", "Test Power Plant", "AAB", "OS", 12321321));
        powerPlantRepository.save(powerPlantEntity1);

        PowerPlantEntity powerPlantEntity2 = powerPlantRepository.save(new PowerPlantEntity(2021, "AA", "Test Power Plant2", "AAB", "OS", 34543));
        powerPlantRepository.save(powerPlantEntity2);

        PowerPlantEntity powerPlantEntity3 = powerPlantRepository.save(new PowerPlantEntity(2021, "AA", "Test Power Plant3", "AAB", "OS", 21321));
        powerPlantRepository.save(powerPlantEntity3);

        Page<PowerPlantEntity> powerPlantEntitiesPage = powerPlantRepository.findAll(PageRequest.of(0, 2));

        assertThat(powerPlantEntitiesPage.getContent()).hasSize(2);
    }
    
    @Test
    public void should_find_plant_by_sequence() {
        PowerPlantEntity powerPlantEntity1 = powerPlantRepository.save(new PowerPlantEntity(2021, "AA", "Test Power Plant", "AAB", "OS", 12321321));
        powerPlantEntity1 = powerPlantRepository.save(powerPlantEntity1);

        PowerPlantEntity powerPlantEntity = powerPlantRepository.findBySequenceNumber(powerPlantEntity1.getSequenceNumber());

        assertThat(powerPlantEntity.getGeneratorStatus()).isEqualTo("OS");
    }

}
