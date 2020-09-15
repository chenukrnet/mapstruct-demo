package com.demo.mapstruct.mavenmapstruct;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PublicSourceWithSetter {
    public String name;

    public String name() {
        log.info("getter is used");
        return name;
    }

    public void name(String name) {
        log.info("setter is used");
        this.name = name;
    }
}
