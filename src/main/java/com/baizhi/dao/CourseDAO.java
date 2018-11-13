package com.baizhi.dao;

import com.baizhi.bean.Banner;
import com.baizhi.bean.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseDAO extends BaseDAO<Course> {
    List<Course> queryAllMust();
    /*分页查询所有*/
    List<Course> queryAllPage(@Param("start")Integer start, @Param("rows")Integer rows);
    /*统计*/
    Long queryAllUserCourseCount();
}
