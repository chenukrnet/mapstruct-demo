package com.demo.mapstruct.mavenmapstruct;

import lombok.Data;

@Data
public class ComplexTarget {
    private String databaseId;
    private String firstName;
    private String age;

    private String bank;
    private String ignored="ok";
}
