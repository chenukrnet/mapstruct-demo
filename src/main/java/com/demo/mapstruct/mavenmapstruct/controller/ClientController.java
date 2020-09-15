package com.demo.mapstruct.mavenmapstruct.controller;

import com.demo.mapstruct.mavenmapstruct.domain.web.request.AddClientAddress;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.CreateClient;
import com.demo.mapstruct.mavenmapstruct.domain.web.response.GeneralResponse;
import com.demo.mapstruct.mavenmapstruct.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService createClientService;
    @PostMapping(path="addClient")
    public ResponseEntity<GeneralResponse> addClient(CreateClient createClient) {
        createClientService.createClient(createClient);
        return ResponseEntity.ok(new GeneralResponse());
    }

    @PostMapping(path="addAddress")
    public ResponseEntity<GeneralResponse> addAddress(AddClientAddress addAddress) {
        createClientService.addAddress(addAddress);
        return ResponseEntity.ok(new GeneralResponse());
    }
}
