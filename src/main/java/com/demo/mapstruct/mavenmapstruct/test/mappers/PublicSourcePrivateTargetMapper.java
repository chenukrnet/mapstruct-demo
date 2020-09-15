package com.demo.mapstruct.mavenmapstruct.test.mappers;

import com.demo.mapstruct.mavenmapstruct.PrivateTarget;
import com.demo.mapstruct.mavenmapstruct.controller.PublicSource;
import org.mapstruct.Mapper;

@Mapper
public interface PublicSourcePrivateTargetMapper {
    PrivateTarget transform(PublicSource publicSource);
}
