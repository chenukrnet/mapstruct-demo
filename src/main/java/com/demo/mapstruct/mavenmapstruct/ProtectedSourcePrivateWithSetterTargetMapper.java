package com.demo.mapstruct.mavenmapstruct;

import com.demo.mapstruct.mavenmapstruct.controller.PublicSource;
import com.demo.mapstruct.mavenmapstruct.test.dto.ProtectedTarget;
import org.mapstruct.Mapper;

@Mapper
public interface ProtectedSourcePrivateWithSetterTargetMapper {
    ProtectedTarget transform(PublicSource publicSource);
}
