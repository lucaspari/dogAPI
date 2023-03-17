package com.example.dogapi.repositories;

import com.example.dogapi.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog,Long> {
}
