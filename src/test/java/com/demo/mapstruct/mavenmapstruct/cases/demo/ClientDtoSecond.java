package com.demo.mapstruct.mavenmapstruct.cases.demo;

import lombok.Data;

import java.util.List;

@Data
public class ClientDtoSecond {
    long clientId;
    String surname;
    String patronymic;
    String name;

    ClientMainAddress clientMainAddress;
    List<ClientAttributeSecond> attributes;
}
