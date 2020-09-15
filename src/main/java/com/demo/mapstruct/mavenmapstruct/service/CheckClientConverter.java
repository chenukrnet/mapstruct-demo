package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.dao.entity.ClientEntity;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CheckClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

//@Mapper(componentModel = "spring")
@Mapper(componentModel = "spring", uses ={CreateClientToEntityConverter.class})

public abstract class CheckClientConverter {
    //для варианта 1
//    @Autowired
//    private CreateClientToEntityConverter createClientToEntityConverter;


    @Mapping(source = "surname", target = "lastName")
    @Mapping(source = "name", target = "firstName")
    @Mapping(source = "patronymic", target = "middleName")
    // Ниже источником можно задать имя переменной источника
    @Mapping(source = "createClient", target = "clientEntity")
    public abstract CheckClient convert(CreateClient createClient);

    // Вариант 1 Использовать композицию
//    public ClientEntity transform(CreateClient createClient) {
//        return createClientToEntityConverter.convert(createClient);
//    }


    // Вариант 2 явно прописать как преобразовать неведомый тип
//    public abstract ClientEntity transform(CreateClient createClient);
}
