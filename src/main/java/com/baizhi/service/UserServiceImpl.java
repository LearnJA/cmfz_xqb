package com.baizhi.service;

import com.baizhi.bean.User;
import com.baizhi.dao.UserDAO;
import com.baizhi.util.FindList;
import com.baizhi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        user.setPassword(MD5Util.md5(user.getUsername()+user.getPassword()));
        userDAO.insert(user);
    }

    @Override
    public void motifyUser(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public String findUser(User user) {
        try{
            String pwd=user.getPassword();
            user=userDAO.queryOne(user);
            boolean vcode=MD5Util.isCodeValidate(pwd,user.getPassword());
            if(vcode){
                return "100";
            }
            return "101";
        }catch(Exception e){
            e.printStackTrace();
            return "102";
        }
    }

    @Override
    public void motifyUserStatus(Integer id) {
        /*查找对应用户*/
        User user=userDAO.queryOneId(id);
        if(user.getStatus()==1){
            user.setStatus(0);
        }else{
            user.setStatus(1);
        }
        /*修改用户状态*/
        userDAO.update(user);
    }

    @Override
    public Map<String, Object> findAllUser(User user) {
        List<User> users=userDAO.queryOneAll(user);
        Long total=userDAO.queryAllCount(user.getStatus());
        System.out.println(users);
        return FindList.findList(total,users);
    }
}
