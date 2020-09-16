package com.demo.mapstruct.mavenmapstruct.cases.modifiers;


import org.mapstruct.Mapper;

@Mapper
public interface PublicSourceWithSetterMapper {
    PublicSourceWithSetter trasform(PublicSourceWithSetter publicSourceWithSetter);
}
