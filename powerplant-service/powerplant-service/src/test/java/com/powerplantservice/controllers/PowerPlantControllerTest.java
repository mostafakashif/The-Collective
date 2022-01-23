/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.powerplantservice.controllers;

import com.powerplantservice.config.SecurityConfig;
import com.powerplantservice.exceptions.ItemNotFoundException;
import com.powerplantservice.facades.PowerPlantFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Mostafa Kashif
 */
@SpringBootTest
@AutoConfigureMockMvc()
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class PowerPlantControllerTest {

    @MockBean
    private PowerPlantFacade powerPlantFacade;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void HTTPNotFoundWhenInvalidSequenceNumber() throws Exception {
        when(powerPlantFacade.getPowerPlant(new Integer(12321))).thenThrow(new ItemNotFoundException());
        mockMvc.perform(get("/powerplants/12321")).andExpect(status().isNotFound());
    }
}
