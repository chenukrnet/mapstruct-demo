package com.demo.mapstruct.mavenmapstruct;

import org.mapstruct.Mapper;

@Mapper
public interface ComplexSourceToComplexTargetMapping {
    ComplexTarget transform(ComplexSource source);
}
