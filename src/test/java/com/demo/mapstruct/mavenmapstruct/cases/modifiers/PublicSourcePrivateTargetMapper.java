package com.demo.mapstruct.mavenmapstruct.cases.modifiers;

import com.demo.mapstruct.mavenmapstruct.controller.PublicSource;
import org.mapstruct.Mapper;

@Mapper
public interface PublicSourcePrivateTargetMapper {
    PrivateTarget transform(PublicSource publicSource);
}
