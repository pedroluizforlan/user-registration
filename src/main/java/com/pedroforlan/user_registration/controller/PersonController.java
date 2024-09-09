package com.pedroforlan.user_registration.controller;

import com.pedroforlan.user_registration.domain.dto.PersonDTO;
import com.pedroforlan.user_registration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PersonDTO> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(personService.findByCpf(cpf));
    }

    @CrossOrigin(origins = "http://IP:8081")
    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personDTO) {
        personDTO.setRegistrationDate(new Date());
        return ResponseEntity.ok(personService.save(personDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO personDTO, @PathVariable Long id) {
        return ResponseEntity.ok(personService.update(id, personDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
