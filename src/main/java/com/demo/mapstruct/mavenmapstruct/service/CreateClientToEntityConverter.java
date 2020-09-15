package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.dao.entity.ClientEntity;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateClientToEntityConverter {
    ClientEntity convert(CreateClient createClient);
}
