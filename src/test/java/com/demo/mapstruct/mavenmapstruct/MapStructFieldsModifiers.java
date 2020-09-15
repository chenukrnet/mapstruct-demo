package com.demo.mapstruct.mavenmapstruct;


import com.demo.mapstruct.mavenmapstruct.controller.PublicSource;
import com.demo.mapstruct.mavenmapstruct.test.dto.ProtectedSourcePrivateWithSetterTargetMapperSamePackage;
import com.demo.mapstruct.mavenmapstruct.test.dto.ProtectedTarget;
import com.demo.mapstruct.mavenmapstruct.test.mappers.PrivateTargetWithSetter;
import com.demo.mapstruct.mavenmapstruct.test.mappers.PublicSourcePrivateTargetMapper;
import com.demo.mapstruct.mavenmapstruct.test.mappers.PublicSourcePrivateWithSetterTargetMapper;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class MapStructFieldsModifiers {

    public static final String TEST_NAME = "TEST_NAME";

    @Order(1)
    @DisplayName("private поля не ставятся тк. нет к ним доступа")
    @Test()
    void publicSourcePrivateTarget(){
        PublicSource publicSource = getPublicSourceObject();
        PublicSourcePrivateTargetMapper mapper = Mappers.getMapper(PublicSourcePrivateTargetMapper.class);
        PrivateTarget target= mapper.transform(publicSource);
        String name =target.getName();
        assertNull( name);
    }
    @Order(2)
    @DisplayName("private поля ставятся если есть сеттер (сеттер должен быть по bean спецификации)")
    @Test()
    void publicSourcePrivateTargetWithSetter(){
        PublicSource publicSource = getPublicSourceObject();
        PublicSourcePrivateWithSetterTargetMapper mapper = Mappers.getMapper(PublicSourcePrivateWithSetterTargetMapper.class);
        PrivateTargetWithSetter target= mapper.transform(publicSource);
        String name =target.getName();
        assertEquals(TEST_NAME, name);
    }


    @Order(3)
    @NotNull
    private PublicSource getPublicSourceObject() {
        PublicSource publicSource = new PublicSource();
        publicSource.name = TEST_NAME;
        return publicSource;
    }
    @Order(4)
    @DisplayName("protected поля не ставятся тк. нет к ним доступа")
    @Test
    void publicSourceProtectedTarget() {
        PublicSource publicSource = getPublicSourceObject();
        ProtectedSourcePrivateWithSetterTargetMapper mapper = Mappers.getMapper(ProtectedSourcePrivateWithSetterTargetMapper.class);
        ProtectedTarget target= mapper.transform(publicSource);
        String name =target.getName();
        assertNull( name);
    }
    @Order(5)
    @DisplayName("protected поля не ставятся. Даже если лежат в 1м пакете с маппером")
    @Test
    void publicSourceProtectedTargetSamePackage() {
        PublicSource publicSource = getPublicSourceObject();
        ProtectedSourcePrivateWithSetterTargetMapperSamePackage mapper = Mappers.getMapper(ProtectedSourcePrivateWithSetterTargetMapperSamePackage.class);
        ProtectedTarget target= mapper.transform(publicSource);
        String name =target.getName();
        assertNull( name);
    }
    @Order(5)
    @DisplayName("public полям ничего не надо")
    @Test
    void publicSourcePublicTarget() {
        PublicSource publicSource = getPublicSourceObject();
        PublicSourcePublicTargetMapper mapper = Mappers.getMapper(PublicSourcePublicTargetMapper.class);
        PublicSource target= mapper.transform(publicSource);
        String name =target.name;
        assertEquals(TEST_NAME, name);
    }

    @Order(5)
    @DisplayName("public полям или методы доступа выбор по умолачению за методами")
    @Test
    void publicSourceDefaultTarget() {
        PublicSourceWithSetter publicSourceWithSetter = new PublicSourceWithSetter();
        publicSourceWithSetter.name(TEST_NAME);
        PublicSourceWithSetterMapper mapper = Mappers.getMapper(PublicSourceWithSetterMapper.class);
        PublicSourceWithSetter target = mapper.trasform(publicSourceWithSetter);
        assertNotEquals(publicSourceWithSetter, target);
        assertEquals(TEST_NAME, target.name());
    }


    @Order(6)
    @DisplayName("private поля в источнике и публичные в приемнике ничего не выйдет")
    @Test
    void privateSourcePublicTarget() {

        PrivateSource source = new PrivateSource(TEST_NAME);

        PrivateSourceToPublicTarget mapper = Mappers.getMapper(PrivateSourceToPublicTarget.class);
        PublicSourceWithSetter target = mapper.trasform(source);
        assertNull( target.name());
    }
    @Order(7)
    @DisplayName("private поля в источнике и публичные в приемнике если добавить в источник геттер то все будет работать")
    @Test
    void privateSourcePublicTargetWithSetters() {

        PrivateSourceWithSetters source = new PrivateSourceWithSetters(TEST_NAME);

        PrivateSourceToPublicTargetWithMethods mapper = Mappers.getMapper(PrivateSourceToPublicTargetWithMethods.class);
        PublicSourceWithSetter target = mapper.trasform(source);
        assertNull( target.name());
    }
}
