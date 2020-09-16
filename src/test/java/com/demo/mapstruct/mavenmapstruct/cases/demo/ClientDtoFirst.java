package com.demo.mapstruct.mavenmapstruct.cases.demo;

import lombok.Data;

import java.util.List;

@Data
public class ClientDtoFirst {
    long clientId;
    String surname;
    String patronymic;
    String name;

    ClientMainAddress clientMainAddress;
    List<ClientAttributeFirst> attributes;
}
