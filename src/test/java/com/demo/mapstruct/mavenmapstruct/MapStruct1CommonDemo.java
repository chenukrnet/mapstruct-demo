package com.demo.mapstruct.mavenmapstruct;

import com.demo.mapstruct.mavenmapstruct.cases.demo.*;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

public class MapStruct1CommonDemo {

    public static final int CLIENT_ID = 128500;
    public static final String SMOLJANOV = "Smoljanov";
    public static final String VICTOROVICH = "Victorovich";
    public static final String SERGEJ = "Sergej";
    public static final String SOME_UAD_ID = "SOME_UAD_ID";

    @Test
    void test() {
        ClientDtoFirst source = new ClientDtoFirst();
        source.setClientId(CLIENT_ID);
        source.setSurname(SMOLJANOV);
        source.setPatronymic(VICTOROVICH);
        source.setName(SERGEJ);
        ClientMainAddress addressMain = new ClientMainAddress();
        addressMain.setUadId(SOME_UAD_ID);
        source.setClientMainAddress(addressMain);
        List<ClientAttributeFirst> listAttributes = new ArrayList<>();
        ClientAttributeFirst attribute1 = new ClientAttributeFirst();
        attribute1.setId(1);
        attribute1.setValue("1");
        listAttributes.add(attribute1);
        ClientAttributeFirst attribute2 = new ClientAttributeFirst();
        attribute2.setId(2);
        attribute2.setValue("2");
        listAttributes.add(attribute2);
        source.setAttributes(listAttributes);
        DemoMapper demoMapper = Mappers.getMapper(DemoMapper.class);
        ClientDtoSecond target = demoMapper.makeOtherDto(source);
        assertEquals(CLIENT_ID, target.getClientId());
        assertEquals(SMOLJANOV, target.getSurname());
        assertEquals(VICTOROVICH, target.getPatronymic());
        assertEquals(SERGEJ, target.getName());
        assertAll(
                () -> assertTrue(source.getClientMainAddress()== target.getClientMainAddress()),
                () -> assertEquals(SOME_UAD_ID, target.getClientMainAddress().getUadId()),
                () -> assertNotEquals(source.getAttributes(), target.getAttributes()),
                () -> assertTrue(target.getAttributes().stream()
                        .filter(e -> e.getId() == 1 && e.getValue().equals("1")).findFirst().isPresent()),
                () -> assertTrue(target.getAttributes().stream()
                        .filter(e -> e.getId() == 2 && e.getValue().equals("2")).findFirst().isPresent())
        );

    }
}
