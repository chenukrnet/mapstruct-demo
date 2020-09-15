package com.demo.mapstruct.mavenmapstruct;


import org.mapstruct.Mapper;

@Mapper
public interface PublicSourceWithSetterMapper {
    PublicSourceWithSetter trasform(PublicSourceWithSetter publicSourceWithSetter);
}
