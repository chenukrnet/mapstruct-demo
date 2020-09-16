package com.demo.mapstruct.mavenmapstruct.cases.modifiers;

import org.mapstruct.Mapper;

@Mapper
public interface PrivateSourceToPublicTargetWithMethods {
    PublicSourceWithSetter trasform(PrivateSourceWithSetters source);
}
