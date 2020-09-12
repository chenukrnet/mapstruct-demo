package com.demo.mapstruct.mavenmapstruct.dao.repository;

import com.demo.mapstruct.mavenmapstruct.dao.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
