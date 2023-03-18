package com.example.dogapi.services;

import com.example.dogapi.models.Dog;
import com.example.dogapi.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {
    private final DogRepository dogRepository;
    @Autowired
    public DogService(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Dog createDog(Dog dog){
        return dogRepository.save(dog);
    }

}
