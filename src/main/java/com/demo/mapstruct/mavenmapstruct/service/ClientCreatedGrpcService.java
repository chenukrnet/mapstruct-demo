package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreatedClient;

public interface ClientCreatedGrpcService {
    void notifyAboutCreation(CreatedClient client);
}
