package com.demo.mapstruct.mavenmapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomisationComplexSourceToComplexTargetMapping {
    @Mapping(target = "databaseId",ignore = true)// даже при совпадении имен я не разрешаю заполнять из источника
    @Mapping(target = "bank", constant = "AB")// Заполним константой
    @Mapping(source = "name", target = "firstName")// Тут можно идти внутрь объектов дотуп через точку
    @Mapping(target = "ignored",ignore = true)// оставляем оригинальное значение
    ComplexTarget transform(ComplexSource source);
}
