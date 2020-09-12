package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.dao.entity.ClientEntity;
import com.demo.mapstruct.mavenmapstruct.dao.repository.ClientRepository;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreatedClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientDao {
    private final ClientRepository clientRepository;
    private final CreatedClientFiller createdClientFiller;
    private CreateClientToEntityConverter createClientToEntityConverter;

    public CreatedClient createClient(CreateClient createClient) {
        ClientEntity newClient = createClientToEntityConverter.convert(createClient);
        CreatedClient dto = new CreatedClient();
         createdClientFiller.fill(newClient, dto);
         return dto;
    }
}
