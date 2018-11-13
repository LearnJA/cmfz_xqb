package com.baizhi.dao;

import com.baizhi.bean.Banner;
import com.baizhi.bean.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuruDAO extends BaseDAO<Guru> {
    /*分页查询所有*/
    List<Guru> queryAllPage(@Param("status")Integer status, @Param("start")Integer start, @Param("rows")Integer rows);
}
