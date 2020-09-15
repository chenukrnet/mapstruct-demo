package com.demo.mapstruct.mavenmapstruct.service;

import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreatedClient;
import org.springframework.stereotype.Service;

@Service
public class ClientCreatedGrpcServiceImpl implements ClientCreatedGrpcService {
    @Override
    public void notifyAboutCreation(CreatedClient client) {

    }
}
