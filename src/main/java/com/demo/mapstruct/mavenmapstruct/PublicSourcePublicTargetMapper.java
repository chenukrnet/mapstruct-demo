package com.demo.mapstruct.mavenmapstruct;

import com.demo.mapstruct.mavenmapstruct.controller.PublicSource;
import org.mapstruct.Mapper;

@Mapper
public interface PublicSourcePublicTargetMapper {
    PublicSource transform(PublicSource publicSource);
}
