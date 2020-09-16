package com.demo.mapstruct.mavenmapstruct.cases.partial;

import lombok.Data;

@Data
public class SomeData {
    long id;
    String name;
    String lastName;
    String middleName;

    public void init() {
        this.id=10L;
        name = "TEST_NAME";
        lastName = "LAST_NAME";
        middleName = "MIDDLE_NAME";
    }

    public void init2() {
        this.id=20L;
        name = "TEST_NAME2";
        lastName = "LAST_NAME2";
        middleName = "MIDDLE_NAME2";
    }
}
