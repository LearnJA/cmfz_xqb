package com.baizhi.dao;

import com.baizhi.bean.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDAO extends BaseDAO<Banner> {
    /*分页查询所有*/
    List<Banner> queryAllPage(@Param("status")Integer status,@Param("start")Integer start, @Param("rows")Integer rows);
}
