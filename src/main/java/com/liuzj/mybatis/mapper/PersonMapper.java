package com.liuzj.mybatis.mapper;

import com.liuzj.mybatis.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author admin
 * @date 2018-11-13
 */
public interface PersonMapper {
    int deleteByPrimaryKey(String id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(@Param(value = "id")String id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Person> selectByIds(List<String> ids);

    List<Person> selectByParams(@Param(value = "id")String id,@Param(value = "name")String name);
}