package com.demo.mapstruct.mavenmapstruct.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "clients", schema = "public", catalog = "test")
public class ClientEntity {
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "patronymic")
    private String patronymic;

    @Basic
    @Column(name = "birthdate")
    private LocalDateTime birthdate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="client_address",
            joinColumns = {
                    @JoinColumn(name="client_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name="address_id")
            }
    )
    private Set<AddressEntity> shippingAddress;
}
