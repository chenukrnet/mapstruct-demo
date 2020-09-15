package com.demo.mapstruct.mavenmapstruct.test.mappers;

import com.demo.mapstruct.mavenmapstruct.PrivateTarget;
import com.demo.mapstruct.mavenmapstruct.controller.PublicSource;
import org.mapstruct.Mapper;

@Mapper
public interface PublicSourcePrivateWithSetterTargetMapper {
    PrivateTargetWithSetter transform(PublicSource publicSource);
}
