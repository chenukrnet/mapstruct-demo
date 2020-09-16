package com.demo.mapstruct.mavenmapstruct;


import com.demo.mapstruct.mavenmapstruct.cases.partial.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static com.demo.mapstruct.mavenmapstruct.cases.partial.ComplexSource.TEST_AGE;
import static com.demo.mapstruct.mavenmapstruct.cases.partial.ComplexSource.TEST_NAME;
import static org.junit.jupiter.api.Assertions.*;

public class MapStruct3PartialMapping {

    @DisplayName("Заполняются только поля у которых совпадают имена, и можно применить конвертации по умолчанию")
    @Test
    void notAllFiledMapping() {
        ComplexSource source = new ComplexSource();
        ComplexSourceToComplexTargetMapping mapper = Mappers.getMapper(ComplexSourceToComplexTargetMapping.class);
        ComplexTarget target = mapper.transform(source);
        assertNull(target.getFirstName());
        assertEquals("" + TEST_AGE, target.getAge());
    }

    @DisplayName("Заполняются только поля у которых совпадают имена, и можно применить конвертации по умолчанию")
    @Test
    void notAllFiledMappingCustomisation() {
        ComplexSource source = new ComplexSource();
        CustomisationComplexSourceToComplexTargetMapping mapper = Mappers.getMapper(CustomisationComplexSourceToComplexTargetMapping.class);
        ComplexTarget target = mapper.transform(source);
        assertEquals(TEST_NAME, target.getFirstName());
        assertEquals("" + TEST_AGE, target.getAge());
        assertEquals("AB", target.getBank());
        assertEquals("ok", target.getIgnored());
    }


    @DisplayName("Можно переиспользовать кастомизации")
    @Test
    void reuseCustomisation() {
        ComplexSource source = new ComplexSource();
        ReUseCustomisationComplexSourceToComplexTargetMapping mapper = Mappers.getMapper(ReUseCustomisationComplexSourceToComplexTargetMapping.class);
        ComplexTarget target = mapper.transform(source);
        assertEquals(TEST_NAME, target.getFirstName());
        assertEquals("" + TEST_AGE, target.getAge());
        assertEquals("AB", target.getBank());
        assertEquals("ok", target.getIgnored());
    }

    @DisplayName("Глубже чем в 1 объект идем через точку")
    @Test
    void deepMapping() {
        SampleSource source = new SampleSource();
        SampleSourceMapping mapper = Mappers.getMapper(SampleSourceMapping.class);
        ComplexTarget target = mapper.transform(source);
        assertEquals(TEST_NAME, target.getFirstName());
        assertEquals("" + TEST_AGE, target.getAge());
        assertEquals("AB", target.getBank());
        assertEquals("ok", target.getIgnored());
    }

    @DisplayName("Можно взять на уровень все поля кроме обозначенных")
    @Test
    void deepMappingEasy() {
        SampleSourceWrapper source = new SampleSourceWrapper();
        source.getSource().init();
        SampleSourceWrapperMapper mapper = Mappers.getMapper(SampleSourceWrapperMapper.class);
        SomeData target = mapper.transform(source);
        assertNotEquals(source, target);
        SomeData dataSource = source.getSource();
        assertEquals(dataSource.getName(), target.getName());
        assertEquals(dataSource.getLastName(), target.getLastName());
        assertEquals(dataSource.getMiddleName(), target.getMiddleName());
        assertNotEquals(dataSource.getId(), target.getId());
    }

    @Disabled
    @DisplayName("Можно взять на уровень все поля кроме обозначенных")
    @Test
    void deepMappingEasyFrom2Sources() {
        SampleSourceWrapper source = new SampleSourceWrapper();
        SomeData otherSource = new SomeData();
        otherSource.init2();
        source.getSource().init();
        SampleSourceWrapperMapper2 mapper = Mappers.getMapper(SampleSourceWrapperMapper2.class);
        SomeData target = mapper.transform(source, otherSource);
        assertNotEquals(source, target);
        SomeData dataSource = source.getSource();
        assertEquals( otherSource.getName(), target.getName());
        assertEquals(dataSource.getLastName(), target.getLastName());
        assertEquals(dataSource.getMiddleName(), target.getMiddleName());
        assertNotEquals(dataSource.getId(), target.getId());
    }

    @DisplayName("Но можно донаполнить объект главное задать какой именно наполняем")
    @Test
    void enrich() {
        SampleSourceWrapper source = new SampleSourceWrapper();
        SomeData otherSource = new SomeData();
        otherSource.init2();
        source.getSource().init();
        SampleSourceWrapperMapper2 mapper = Mappers.getMapper(SampleSourceWrapperMapper2.class);
        SomeData target = mapper.transform(source, otherSource);
        mapper.fill(source, target);
        assertNotEquals(source, target);
        SomeData dataSource = source.getSource();
        assertEquals( dataSource.getName(), target.getName());
        assertEquals(otherSource.getLastName(), target.getLastName());
        assertEquals(otherSource.getMiddleName(), target.getMiddleName());
        assertNotEquals(otherSource.getId(), target.getId());
    }
}
