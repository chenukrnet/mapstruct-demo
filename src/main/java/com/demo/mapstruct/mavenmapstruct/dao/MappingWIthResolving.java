package com.demo.mapstruct.mavenmapstruct.dao;

import com.demo.mapstruct.mavenmapstruct.dao.entity.AddressEntity;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.AddClientAddress;
import com.demo.mapstruct.mavenmapstruct.domain.web.response.ClientUnionAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClientResolver.class})
public interface MappingWIthResolving {

    @Mapping(source = "source", target = "clientEntity")
    @Mapping(source = "source", target = "addressEntity")
    ClientUnionAddress convert(AddClientAddress source);


    AddressEntity transform(AddClientAddress source);
}
