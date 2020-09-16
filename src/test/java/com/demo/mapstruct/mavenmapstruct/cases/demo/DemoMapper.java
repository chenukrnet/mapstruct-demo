package com.demo.mapstruct.mavenmapstruct.cases.demo;

import org.mapstruct.Mapper;

@Mapper
public interface DemoMapper {
    ClientDtoSecond makeOtherDto(ClientDtoFirst clientDtoFirst);
}
