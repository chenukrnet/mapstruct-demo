package com.demo.mapstruct.mavenmapstruct.cases.modifiers;

import com.demo.mapstruct.mavenmapstruct.controller.PublicSource;
import org.mapstruct.Mapper;

@Mapper
public interface ProtectedSourcePrivateWithSetterTargetMapperSamePackage {
    ProtectedTarget transform(PublicSource publicSource);
}
