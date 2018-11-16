package com.liuzj.mybatis.service;

import com.liuzj.mybatis.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuzj
 * @date 2018-11-13
 */
public interface PersonService {

    /**
     * 新增
     *
     * @param record 新增实体
     * @return 执行成功记录数
     */
    int insert(Person record);

    /**
     * 根据主键查找
     *
     * @param id 主键
     * @return 实体对象
     */
    Person selectByPrimaryKey(@Param(value = "id")String id);

    /**
     * 根据ID集合查找对象
     *
     * @param ids ID集合
     * @return list
     */
    List<Person> selectByIds(List<String> ids);

    /**
     * 根据参数查询
     *
     * @param id ID
     * @param name 名字
     * @return list
     */
    List<Person> selectByParams(@Param(value = "id")String id, @Param(value = "name")String name);
}
