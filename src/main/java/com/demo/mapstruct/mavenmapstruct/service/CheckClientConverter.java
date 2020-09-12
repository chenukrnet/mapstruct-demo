package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.domain.web.request.CheckClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CheckClientConverter {
    @Mapping(source = "surname", target = "lastName")
    @Mapping(source = "name", target = "firstName")
    @Mapping(source = "middleName", target = "patronymic")
    CheckClient convert(CreateClient createClient);
}
