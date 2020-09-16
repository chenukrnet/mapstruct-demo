package com.demo.mapstruct.mavenmapstruct.cases.modifiers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PublicSourceWithSetter {
    public String name;

//    public PublicSourceWithSetter(String testName) {
//        synchronized (this) {
//            log.info("constructor is used");
//        }
//        this.name = testName;
//    }

    public String getName() {
        synchronized (this) {
            log.info("getter is used");
        }
        return name;
    }


    public void setName(String name) {
        synchronized (this) {

            log.info("setter is used");
        }
        this.name = name;
    }
}
