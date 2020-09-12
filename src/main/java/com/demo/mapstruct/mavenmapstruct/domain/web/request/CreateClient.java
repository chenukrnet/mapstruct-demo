package com.demo.mapstruct.mavenmapstruct.domain.web.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateClient {
    private String surname;
    private String name;
    private String patronymic;
    private LocalDateTime birthdate;
}
