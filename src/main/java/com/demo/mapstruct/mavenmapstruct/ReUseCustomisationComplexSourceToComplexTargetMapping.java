package com.demo.mapstruct.mavenmapstruct;

import org.mapstruct.Mapper;

@Mapper
public interface ReUseCustomisationComplexSourceToComplexTargetMapping {
    @MyUberAnnotation
    ComplexTarget transform(ComplexSource source);
}
