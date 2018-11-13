package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<T> {
    /*增*/
    void insert(T t);
    /*删*/
    void delete(T t);
    /*批量删除*/
    void deleteAny(@Param("ids") int[] ids);
    /*改*/
    void update(T t);
    /*查一个*/
    T queryOne(T t);
    /*查所有*/
    List<T> queryAll();
    /*条件查所有*/
    List<T> queryOneAll(T t);
    /*获取总条数total*/
    Long queryAllCount(@Param("status")Integer status);
}
