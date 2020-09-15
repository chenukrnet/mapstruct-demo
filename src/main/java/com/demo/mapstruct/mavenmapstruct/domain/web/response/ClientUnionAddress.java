package com.demo.mapstruct.mavenmapstruct.domain.web.response;

import com.demo.mapstruct.mavenmapstruct.dao.entity.AddressEntity;
import com.demo.mapstruct.mavenmapstruct.dao.entity.ClientEntity;
import lombok.Data;

@Data
public class ClientUnionAddress {

    private ClientEntity clientEntity;

    private AddressEntity addressEntity;
}
