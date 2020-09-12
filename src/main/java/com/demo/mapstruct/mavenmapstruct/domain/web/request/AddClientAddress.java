package com.demo.mapstruct.mavenmapstruct.domain.web.request;

import lombok.Data;

@Data
public class AddClientAddress {
    private Long clientId;
    private String country;
    private String city;
    private String street;
    private Integer building;
    private String block;
    private String apartment;
}
