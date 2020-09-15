package com.demo.mapstruct.mavenmapstruct.dao;

import com.demo.mapstruct.mavenmapstruct.dao.entity.ClientEntity;
import com.demo.mapstruct.mavenmapstruct.dao.repository.ClientRepository;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.AddClientAddress;
import com.demo.mapstruct.mavenmapstruct.domain.web.request.ClientSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientResolver {
    private final ClientRepository clientRepository;
    public ClientEntity resolveClient(AddClientAddress searchDto) {
        Optional<ClientEntity> byId = clientRepository.findById(searchDto.getClientId());
        return byId.orElseThrow(NoSuchElementException::new);
    }

}
