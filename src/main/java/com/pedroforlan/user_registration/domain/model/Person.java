package com.pedroforlan.user_registration.domain.model;

import com.pedroforlan.user_registration.domain.dto.PersonDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String cpf;
    @Column(length = 100)
    private String phone;
    @Column(length = 100)
    private Date registrationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String telefone) {
        this.phone = telefone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date dataCadastro) {
        this.registrationDate = dataCadastro;
    }

    public static Person toDocument(PersonDTO personDTO){
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setPhone(personDTO.getPhone());
        person.setRegistrationDate(personDTO.getRegistrationDate());
        return person;
    }
}
