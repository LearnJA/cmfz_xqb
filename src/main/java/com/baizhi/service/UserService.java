package com.baizhi.service;

import com.baizhi.bean.User;

import java.util.Map;

public interface UserService {
    /*用户注册*/
    void addUser(User user);
    /*用户信息修改*/
    void motifyUser(User user);
    /*用户登录*/
    String findUser(User user);
    /*用户状态修改*/
    void motifyUserStatus(Integer id);
    /*根据状态查所有*/
    Map<String,Object> findAllUser(User user);
}
