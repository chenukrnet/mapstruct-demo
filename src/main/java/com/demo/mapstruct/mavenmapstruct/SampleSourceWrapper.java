package com.demo.mapstruct.mavenmapstruct;

import lombok.Data;

@Data
public class SampleSourceWrapper {
    private SomeData source = new SomeData();
    private SomeData otherSource = new SomeData();
}
