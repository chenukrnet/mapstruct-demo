package com.demo.mapstruct.mavenmapstruct;

import org.mapstruct.Mapper;

@Mapper
public interface PrivateSourceToPublicTargetWithMethods {
    PublicSourceWithSetter trasform(PrivateSourceWithSetters source);
}
