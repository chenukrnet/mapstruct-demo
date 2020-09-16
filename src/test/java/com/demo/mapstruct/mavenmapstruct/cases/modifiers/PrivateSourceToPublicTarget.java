package com.demo.mapstruct.mavenmapstruct.cases.modifiers;

import org.mapstruct.Mapper;

@Mapper
public interface PrivateSourceToPublicTarget {
    PublicSourceWithSetter trasform(PrivateSource source);
}
