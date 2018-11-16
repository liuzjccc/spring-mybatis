package com.liuzj.mybatis.service.impl;

import com.liuzj.mybatis.entity.Person;
import com.liuzj.mybatis.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class PersonServiceImplTest {

    Logger logger = LoggerFactory.getLogger(PersonServiceImplTest.class);

    @Autowired
    PersonService personService;

    @Test
    public void insert() {
        Person person = new Person();
        person.setId("65666");
        person.setName("Tom");
        personService.insert(person);
    }

    @Test
    public void selectByPrimaryKey() {
        personService.selectByPrimaryKey("65666");
    }

    @Test
    public void selectByParams(){
        personService.selectByParams("65666",null);
    }

    @Test
    public void selectByIds(){
        List<String> ids = new ArrayList<String>();
        ids.add("65666");
        personService.selectByIds(ids);
    }
}