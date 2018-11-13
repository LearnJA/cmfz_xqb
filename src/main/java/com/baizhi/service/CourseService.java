package com.baizhi.service;

import com.baizhi.bean.Course;
import com.baizhi.bean.User;

import java.util.List;
import java.util.Map;

public interface CourseService {
    /*查询所有必修课*/
    List<Course> findAllMust();
    /*用户查询所有自选课*/
    List<Course> findUserCourse(Course course);
    /*分页查看所有用户的自选课程*/
    Map<String,Object> findAllUserCourse(Integer page, Integer rows);
    /*添加选课*/
    void addCourse(Course course);
    /*删除选课*/
    void removeCourse(Course course);
    /*修改进度*/
    void motifyCourse(Course course);
}
