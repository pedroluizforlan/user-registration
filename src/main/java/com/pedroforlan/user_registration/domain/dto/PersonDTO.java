package com.pedroforlan.user_registration.domain.dto;

import com.pedroforlan.user_registration.domain.model.Person;

import java.util.Date;

public class PersonDTO {

    private String name;
    private String cpf;
    private String phone;
    private Date registrationDate;


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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public static PersonDTO toDTO(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(person.getName());
        personDTO.setCpf(person.getCpf());
        personDTO.setPhone(person.getPhone());
        personDTO.setRegistrationDate(person.getRegistrationDate());
        return personDTO;
    }
}
