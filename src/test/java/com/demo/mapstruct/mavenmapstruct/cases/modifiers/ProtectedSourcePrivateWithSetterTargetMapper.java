package com.demo.mapstruct.mavenmapstruct.cases.modifiers;

import com.demo.mapstruct.mavenmapstruct.controller.PublicSource;
import org.mapstruct.Mapper;

@Mapper
public interface ProtectedSourcePrivateWithSetterTargetMapper {
    ProtectedTarget transform(PublicSource publicSource);
}
