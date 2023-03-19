package com.example.dogapi.controllers;

import com.example.dogapi.dto.DogDTO;
import com.example.dogapi.models.Dog;
import com.example.dogapi.services.DogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DogControllerTest {
    private DogController dogController;
    @Mock
    private DogService dogService;
    @Mock
    private ModelMapper modelMapper;

    private DogDTO dogDTO;
    private Dog dog;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private MockMvc mockMvc;



    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        dogController = new DogController(dogService,modelMapper);
        mockMvc = MockMvcBuilders.standaloneSetup(dogController).build();
        init();
    }
    void init(){
        dogDTO = new DogDTO(1L,"Buddy",7,"Rottweiler");
        dog = new Dog(1L,"Buddy",7,"Rottweiler");
    }
    @Test
    void getMessage() {
        // ACT
        String result = dogController.getMessage();
        // ASSERT
        assertEquals("Hello Dog",result);
        assertNotNull(result);
    }


    @Test
    void createDog() throws Exception {
        // ARRANGE
        when(dogService.createDog(any(Dog.class))).thenReturn(dog);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/dog/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dogDTO)))
                .andExpect(status().isCreated());
    }
}