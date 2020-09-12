package com.demo.mapstruct.mavenmapstruct.domain.web.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckClient {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDateTime birthdate;
}
