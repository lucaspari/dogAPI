package com.example.dogapi.controllers;

import com.example.dogapi.dto.DogDTO;
import com.example.dogapi.models.Dog;
import com.example.dogapi.services.DogService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/dog")
public class DogController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DogService dogService;
    @GetMapping("/")
    public String getMessage(){
        return "Hello Dog";
    }

    @PostMapping("/create")
    public ResponseEntity<DogDTO> createDog(@RequestBody @Valid DogDTO json){
            Dog dog = modelMapper.map(json,Dog.class);
            dogService.createDog(dog);
            DogDTO dogDTO = modelMapper.map(dog,DogDTO.class);
            return new ResponseEntity<>(dogDTO,HttpStatus.CREATED);
    }
}
