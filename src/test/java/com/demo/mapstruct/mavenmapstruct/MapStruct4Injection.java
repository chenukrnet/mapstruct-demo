package com.demo.mapstruct.mavenmapstruct;

import com.demo.mapstruct.mavenmapstruct.dao.MappingWIthResolving;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CheckClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import com.demo.mapstruct.mavenmapstruct.service.CheckClientConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MapStruct4Injection {

    @Autowired
    private CheckClientConverter checkClientConverter;
    @Autowired
    private MappingWIthResolving mappingWIthResolving;// Показать реализацию
    private CreateClient createClient;

    @BeforeEach
    void setUp() {
        createClient = new CreateClient();
        createClient.setName("name");
        createClient.setSurname("surename");
        createClient.setBirthdate(LocalDateTime.now());
        createClient.setPatronymic("patromic");
    }

    @Test
    void contextUp() {
        CheckClient request = checkClientConverter.convert(createClient);
        assertEquals(createClient.getName(), request.getFirstName());
        assertEquals(createClient.getName(), request.getClientEntity().getName());
    }


}
