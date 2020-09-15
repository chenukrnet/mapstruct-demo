package com.demo.mapstruct.mavenmapstruct.domain.web.request;

import com.demo.mapstruct.mavenmapstruct.dao.entity.ClientEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckClient {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDateTime birthdate;

    private ClientEntity clientEntity;
}
