package com.example.dogapi.services;

import com.example.dogapi.models.Dog;
import com.example.dogapi.repositories.DogRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class DogServiceTest {
    private DogService  dogService;

    @Mock
    private DogRepository dogRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        dogService = new DogService(dogRepository);
    }

    @Test
    void createDog() {
        Dog dog = new Dog();
        dog.setName("buddy");
        when(dogRepository.save(any(Dog.class))).thenReturn(dog);

        Dog result = dogService.createDog(dog);

        Assert.assertEquals(dog.getName(),result.getName());
    }
}