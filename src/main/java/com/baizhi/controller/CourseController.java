package com.baizhi.controller;

import com.baizhi.bean.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    private Map<String,Object> result=new HashMap<String,Object>();

    /*展示所有必修课程*/
    @RequestMapping(value = "/must")
    public @ResponseBody List<Course> findAllMust(){
        List<Course> list=courseService.findAllMust();
        return list;
    }
    /*展示所有自选课程*/
    @RequestMapping(value = "/allUserCourse")
    public @ResponseBody Map<String,Object> findAllUser(Integer page,Integer rows){
        result=courseService.findAllUserCourse(page,rows);
        return result;
    }

    /*展示用户所有课程*/
    @RequestMapping(value = "/userAllCourse")
    public @ResponseBody List<Course> findUserAll(Course course){
        List<Course> list=courseService.findUserCourse(course);
        return list;
    }

    /*添加选课*/
    @RequestMapping(value = "/addCourse")
    public @ResponseBody Map<String,Object> addUserCourse(Course course){
        try {
            course.setCreatTime(new Date());
            course.setUser_id(0);
            courseService.addCourse(course);
            result.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
        }
        return result;
    }

    /*删除自选课*/
    @RequestMapping(value = "/delCourse")
    public @ResponseBody Map<String,Object> delCourse(Course course){
        try{
            courseService.removeCourse(course);
            result.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
        }
        return result;
    }
}
