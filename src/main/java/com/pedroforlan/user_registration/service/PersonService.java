package com.pedroforlan.user_registration.service;

import com.pedroforlan.user_registration.domain.dto.PersonDTO;
import com.pedroforlan.user_registration.domain.model.Person;
import com.pedroforlan.user_registration.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;


    public List<PersonDTO> getAll(){
       return personRepository
               .findAll()
               .stream().map(PersonDTO::toDTO)
               .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id){
        return personRepository.findById(id).map(PersonDTO::toDTO).get();
    }

    public PersonDTO findByCpf(String cpf){
        Person person = personRepository.findByCpf(cpf);
        if(person != null){
            return PersonDTO.toDTO(person);
        }
        return null;
    }

    public PersonDTO save(PersonDTO personDTO){
        Person person = Person.toDocument(personDTO);

        personRepository.save(person);
        return PersonDTO.toDTO(person);
    }

    public PersonDTO update(Long id, PersonDTO personDTO){
        Person person = Person.toDocument(findById(id));
        personRepository.save(personToUpdate(person,Person.toDocument(personDTO)));
        return PersonDTO.toDTO(person);
    }

    public void delete(Long id){
        Person person = Person.toDocument(findById(id));
        personRepository.delete(person);
    }

    public Person personToUpdate(Person dbPerson, Person personToUpdate){
        Person person = personToUpdate;
        person.setId(dbPerson.getId());
        return person;
    }

}
