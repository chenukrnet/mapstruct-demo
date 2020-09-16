package com.demo.mapstruct.mavenmapstruct.cases.partial;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

// при заполнении по умолчанию если в целевом объекте надо что то сделать с  коллекциями то хорошо было бы выбрать стратегию
// дефолтное поведение вычистить все и заполнить из источника (можно добавлять или не трогать на выбор)
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ACCESSOR_ONLY)
public interface SampleSourceWrapperMapper2 {
    @Mapping(target = "id", ignore = true )
    @Mapping(target = ".", source ="source" )
    @Mapping(source = "otherSource.name", target = "name")
    SomeData transform(SampleSourceWrapper source, SomeData otherSource);

    @Mapping(source = "source.name", target = "name")
    void fill(SampleSourceWrapper source, @MappingTarget()  SomeData target);

}
