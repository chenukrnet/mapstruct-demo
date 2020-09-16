package com.demo.mapstruct.mavenmapstruct.cases.partial;

import lombok.Data;

@Data
public class ComplexSource {

    public static final String TEST_NAME = "TEST_NAME";
    public static final long TEST_ID = 10L;
    public static final int TEST_AGE = 10;
    public static final String IGNORED = "ignored";

    private long id= TEST_ID;
    private String name = TEST_NAME;
    private Byte age= TEST_AGE;

    private String ignored= IGNORED;


}
