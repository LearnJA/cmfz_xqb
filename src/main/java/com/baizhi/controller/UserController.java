package com.baizhi.controller;

import com.baizhi.bean.User;
import com.baizhi.service.UserService;
import com.baizhi.util.FileParm;
import com.baizhi.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private Map<String,Object> result=new HashMap<String,Object>();
    private FileParm fileParm=new FileParm();

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> userLogin(User user){
        try {
            userService.findUser(user);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("massage",e.getMessage());
        }
        return result;
    }

    /*用户注册*/
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> userRegist(User user, MultipartFile file, HttpSession session){
        try {
            fileParm=UploadFile.addfile("/UserHeadPic",file,session);
            user.setDate(new Date());
            user.setHeadPic(fileParm.getPath());
            user.setStatus(1);
            System.out.println(user);
            userService.addUser(user);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("massage",e.getMessage());
        }
        return result;
    }

    /*修改状态*/
    @RequestMapping(value = "/updtStatus")
    public Map<String,Object> updateUserStatus(Integer id){
        try{
            userService.motifyUserStatus(id);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
        }
        return result;
    }

    /*根据状态查所有用户*/
    @RequestMapping(value = "/findAllUser")
    public @ResponseBody Map<String,Object> findAllUser(User user){
        try{
            result=userService.findAllUser(user);
            return result;
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("massage",e.getMessage());
            return result;
        }
    }
}
