package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.domain.web.request.AddClientAddress;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;

public interface ClientService {
    void createClient(CreateClient createClient);

    void addAddress(AddClientAddress addAddress);
}
