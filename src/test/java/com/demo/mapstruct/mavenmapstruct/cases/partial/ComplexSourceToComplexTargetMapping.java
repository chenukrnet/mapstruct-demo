package com.demo.mapstruct.mavenmapstruct.cases.partial;

import org.mapstruct.Mapper;

@Mapper
public interface ComplexSourceToComplexTargetMapping {
    ComplexTarget transform(ComplexSource source);
}
