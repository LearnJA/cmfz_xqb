package com.baizhi.service;

import com.baizhi.bean.Course;
import com.baizhi.bean.User;
import com.baizhi.dao.CourseDAO;
import com.baizhi.util.FindList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;
    private Course course;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findAllMust() {
        return courseDAO.queryAllMust();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findUserCourse(Course course) {
        return courseDAO.queryOneAll(course);
    }

    @Override
    public Map<String,Object> findAllUserCourse(Integer page, Integer rows) {
        Integer start=(page-1)*rows;
        List<Course> courses=courseDAO.queryAllPage(start,rows);
        Long total=courseDAO.queryAllUserCourseCount();
        Map<String,Object> result=FindList.findList(total,courses);
        return result;
    }

    @Override
    public void addCourse(Course course) {
        courseDAO.insert(course);
    }

    @Override
    public void removeCourse(Course course) {
        courseDAO.delete(course);
    }

    @Override
    public void motifyCourse(Course course) {
        courseDAO.update(course);
    }
}
