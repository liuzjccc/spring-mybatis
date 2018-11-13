package com.liuzj.mybatis.mapper;

import com.liuzj.mybatis.entity.Person;

/**
 * @author admin
 * @date 2018-11-13
 */
public interface PersonMapper {
    int deleteByPrimaryKey(String id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}