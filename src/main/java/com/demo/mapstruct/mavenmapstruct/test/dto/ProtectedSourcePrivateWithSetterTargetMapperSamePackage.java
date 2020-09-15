package com.demo.mapstruct.mavenmapstruct.test.dto;

import com.demo.mapstruct.mavenmapstruct.controller.PublicSource;
import org.mapstruct.Mapper;

@Mapper
public interface ProtectedSourcePrivateWithSetterTargetMapperSamePackage {
    ProtectedTarget transform(PublicSource publicSource);
}
