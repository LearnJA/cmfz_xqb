package com.baizhi.dao;

import com.baizhi.bean.User;

public interface UserDAO extends BaseDAO<User> {
    /*用户状态修改*/
    User queryOneId(Integer id);
}
