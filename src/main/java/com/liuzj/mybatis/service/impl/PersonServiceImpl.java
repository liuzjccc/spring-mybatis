package com.liuzj.mybatis.service.impl;

import com.liuzj.mybatis.entity.Person;
import com.liuzj.mybatis.mapper.PersonMapper;
import com.liuzj.mybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuzj
 * @date 2018-11-13
 * @see PersonService
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;

    public int insert(Person record) {
        return personMapper.insert(record);
    }

    public Person selectByPrimaryKey(String id) {
        return personMapper.selectByPrimaryKey(id);
    }

    public List<Person> selectByIds(List<String> ids) {
        return personMapper.selectByIds(ids);
    }

    public List<Person> selectByParams(String id, String name) {
        return personMapper.selectByParams(id,name);
    }
}
