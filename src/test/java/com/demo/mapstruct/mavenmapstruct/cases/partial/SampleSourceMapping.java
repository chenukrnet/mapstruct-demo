package com.demo.mapstruct.mavenmapstruct.cases.partial;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SampleSourceMapping {
    @Mapping(target = "databaseId",ignore = true)// даже при совпадении имен я не разрешаю заполнять из источника
    @Mapping(target = "bank", constant = "AB")// Заполним константой
    @Mapping(source = "source.age", target = "age")// Тут можно идти внутрь объектов дотуп через точку
    @Mapping(source = "source.name", target = "firstName")// Тут можно идти внутрь объектов дотуп через точку
    @Mapping(target = "ignored",ignore = true)// оставляем оригинальное значение
    ComplexTarget transform(SampleSource source);
}
