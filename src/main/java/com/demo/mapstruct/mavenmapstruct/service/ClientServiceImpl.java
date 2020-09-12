package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.domain.web.request.AddClientAddress;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreatedClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final CheckClientService checkClientService;
    private final ClientDao clientDao;
    private final ClientCreatedGrpcService clientCreatedGrpcService;
    @Override
    public void createClient(CreateClient createClient) {
        checkClientService.checkClient(createClient);
        CreatedClient client = clientDao.createClient(createClient);
        clientCreatedGrpcService.notifyAboutCreation(client);
    }

    @Override
    public void addAddress(AddClientAddress addAddress) {

    }
}
