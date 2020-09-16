package com.demo.mapstruct.mavenmapstruct.cases.partial;

import lombok.Data;

@Data
public class SampleSourceWrapper {
    private SomeData source = new SomeData();
    private SomeData otherSource = new SomeData();
}
