package com.demo.mapstruct.mavenmapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper
public interface SampleSourceWrapperMapper {
    @Mapping(target = "id", ignore = true )
    @Mapping(target = ".", source ="source" )
    SomeData transform(SampleSourceWrapper source) ;
}
