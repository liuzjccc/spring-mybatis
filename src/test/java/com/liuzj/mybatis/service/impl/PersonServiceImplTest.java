package com.liuzj.mybatis.service.impl;

import com.liuzj.mybatis.entity.Person;
import com.liuzj.mybatis.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class PersonServiceImplTest {

    @Autowired
    PersonService personService;

    @Test
    public void insert() {
        Person person = new Person();
        person.setId("15");
        person.setName("Tom");
        personService.insert(person);
    }

    @Test
    public void selectByPrimaryKey() {
    }
}