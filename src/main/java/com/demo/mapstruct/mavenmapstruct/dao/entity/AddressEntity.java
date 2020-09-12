package com.demo.mapstruct.mavenmapstruct.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dictionary_address", schema = "public", catalog = "test")
public class AddressEntity {
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "street")
    private String street;

    @Basic
    @Column(name = "building")
    private Integer building;
    @Basic
    @Column(name = "block")
    private String block;
    @Basic
    @Column(name = "apartment")
    private String apartment;


}
