package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Animal;
import com.example.demo.model.AnimalResponse;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class AnimalController {
    
    @GetMapping(value="/animals")
    public List<Animal> getAllAnimals() {
        List<Animal> result = new ArrayList<>();
        result.add(new Animal("cat", "grey"));
        result.add(new Animal("dog", "black"));
        result.add(new Animal("turttle", "green"));
        result.add(new Animal("mouse", "white"));
        result.add(new Animal("parrot", "yellow"));
        result.add(new Animal("lion", "orange"));
        return result;
    }
    
    @PostMapping("/animal")
    public ResponseEntity<AnimalResponse> createAnimal(@RequestBody final Animal animal){
        System.out.println(animal);
        AnimalResponse response = new AnimalResponse(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping(value="/animal/{name}")
    public Animal getAnimalById(@PathVariable String name) {
        return new Animal(name,"transparent");
    }
    
}
