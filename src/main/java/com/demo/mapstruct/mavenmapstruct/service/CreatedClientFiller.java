package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.dao.entity.ClientEntity;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreatedClient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CreatedClientFiller {
    void fill(ClientEntity source, @MappingTarget CreatedClient target);
}
