package com.demo.mapstruct.mavenmapstruct;

import org.mapstruct.Mapper;

@Mapper
public interface PrivateSourceToPublicTarget {
    PublicSourceWithSetter trasform(PrivateSource source);
}
