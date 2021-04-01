package com.kuer.study.spring.boot02.config.config;

import com.kuer.study.spring.boot02.config.config.entity.Dog;
import com.kuer.study.spring.boot02.config.config.entity.EmailEntity;
import com.kuer.study.spring.boot02.config.config.entity.Person;
import com.kuer.study.spring.boot02.config.config.entity.Person2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class ConfigApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private Person2 person2;

    @Autowired
    private EmailEntity entity;

    @Test
    void contextLoads() {
        System.out.println(person);
        System.out.println(person2);
    }

    @Test
    void test() {
        entity.setAddress("wkj");
        System.out.println(entity);
    }


}
