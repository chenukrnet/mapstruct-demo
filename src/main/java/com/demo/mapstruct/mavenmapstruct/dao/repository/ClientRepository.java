package com.demo.mapstruct.mavenmapstruct.dao.repository;

import com.demo.mapstruct.mavenmapstruct.dao.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
