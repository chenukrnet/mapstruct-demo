package com.demo.mapstruct.mavenmapstruct.cases.partial;

import com.demo.mapstruct.mavenmapstruct.cases.partial.ComplexSource;
import com.demo.mapstruct.mavenmapstruct.cases.partial.ComplexTarget;
import com.demo.mapstruct.mavenmapstruct.cases.partial.MyUberAnnotation;
import org.mapstruct.Mapper;

@Mapper
public interface ReUseCustomisationComplexSourceToComplexTargetMapping {
    @MyUberAnnotation
    ComplexTarget transform(ComplexSource source);
}
