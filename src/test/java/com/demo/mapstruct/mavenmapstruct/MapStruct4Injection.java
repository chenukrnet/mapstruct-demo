package com.demo.mapstruct.mavenmapstruct;

import com.demo.mapstruct.mavenmapstruct.dao.MappingWIthResolving;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.AddClientAddress;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CheckClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreatedClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.response.ClientUnionAddress;
import com.demo.mapstruct.mavenmapstruct.service.CheckClientConverter;
import com.demo.mapstruct.mavenmapstruct.service.ClientDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MapStruct4Injection {

    @Autowired
    private CheckClientConverter checkClientConverter;
    private CreateClient createClient;


    @Autowired
    private MappingWIthResolving mappingWIthResolving;// Показать реализацию
    @Autowired
    private ClientDao clientDao;

    @BeforeEach
    void setUp() {
        createClient = new CreateClient();
        createClient.setName("name");
        createClient.setSurname("surename");
        createClient.setBirthdate(LocalDateTime.now());
        createClient.setPatronymic("patromic");
    }

    @DisplayName("Не обязательно использовать в маппере только преобразования")
    @Test
    void injectionTest() {
        CheckClient request = checkClientConverter.convert(createClient);
        assertEquals(createClient.getName(), request.getFirstName());
        assertEquals(createClient.getName(), request.getClientEntity().getName());
    }


    @DisplayName("Не обязательно использовать в маппере только преобразования")
    @Test
    void resolveTest() {
        Long id = clientDao.createClient(createClient).getId();
        AddClientAddress source = new AddClientAddress();
        source.setClientId(id);
        source.setCountry("Ukraine");
        source.setCity("Dnipro");
        source.setStreet("Mi-mi");
        source.setBuilding(15);
        ClientUnionAddress convert = mappingWIthResolving.convert(source);
        assertEquals(createClient.getName(), convert.getClientEntity().getName());
        assertEquals(source.getCity(), convert.getAddressEntity().getCity());

    }


    

}
