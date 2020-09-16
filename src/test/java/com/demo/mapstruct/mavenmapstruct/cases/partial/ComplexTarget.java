package com.demo.mapstruct.mavenmapstruct.cases.partial;

import lombok.Data;

@Data
public class ComplexTarget {
    private String databaseId;
    private String firstName;
    private String age;

    private String bank;
    private String ignored="ok";
}
