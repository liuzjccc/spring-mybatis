package com.liuzj.mybatis.service;

import com.liuzj.mybatis.entity.Person;

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
    Person selectByPrimaryKey(String id);
}
