package com.br.testepet.api;

import com.br.testepet.dto.ResponseObject;
import com.br.testepet.entity.Pet;
import com.br.testepet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "pet")
public class PetApi {

    @Autowired
    private PetRepository petRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Pet> getPet(){
        return petRepository.findAll();
    }

    @GetMapping(path = "/find/{id}")
    public @ResponseBody
    Optional<Pet> getPetById(@PathVariable(name = "id") Long id){
            return petRepository.findById(id);
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity savePaciente(@RequestBody Pet pet){
        try{
            pet = petRepository.save(pet);
            return ResponseEntity.ok(pet);
        }catch (Exception e){
            return new ResponseEntity(new ResponseObject(pet,"Animal não inserido, nome duplicado"), HttpStatus.valueOf(400));

        }
    }

    @PutMapping(path = "/edit")
    public @ResponseBody ResponseEntity<?> update(@RequestBody Pet pet){
        try{
            pet = petRepository.save(pet);
            return ResponseEntity.ok(pet);
        }catch (Exception e){
            return new ResponseEntity(new ResponseObject(pet,"Animal não inserido, nome duplicado"), HttpStatus.valueOf(400));

        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        try {
            petRepository.deleteById(id);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            return (ResponseEntity<?>) ResponseEntity.status(500);
        }
    }
}
