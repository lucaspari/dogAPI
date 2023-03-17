package com.example.dogapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogDTO {
    private long id;
    private String name;
    private Integer age;
    private String breed;


}
