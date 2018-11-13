package com.baizhi.controller;

import com.baizhi.bean.Admain;
import com.baizhi.service.AdmainService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/admain")
@SessionAttributes(value={"admain"})
public class AdmainController {

    @Resource
    private AdmainService admainService;

    private Map<String,Object> result=new HashMap<String,Object>();

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Admain admain, ModelMap modelMap,HttpSession session){
        //获取真实验证码
        String realCode= (String) session.getAttribute("validationCode");
        System.out.println(realCode);
        if(admain.getEnCode().equals(realCode)) {
            admainService.addAdmain(admain);
            modelMap.addAttribute("admain", admain);
            return "redirect:/back/main/main.jsp";
        }else{
            return "login";
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Admain admain, ModelMap modelMap,HttpSession session){
        System.out.println(admain);
        String realCode= (String) session.getAttribute("validationCode");
        String enCode=admain.getEnCode();
        if (enCode.equals(realCode)) {
            Admain m = admainService.findOneAdmain(admain);
            System.out.println(m);
            if(m!=null) {
                modelMap.addAttribute("admain", m);
                return "redirect:/back/main/main.jsp";
            }else{
                return "login";
            }
        }else{
            return "login";
        }
    }
    /*退出登录*/
    @RequestMapping(value = "downLoad",method = RequestMethod.GET)
    public String downLoad(HttpSession session){
        session.invalidate();
        System.out.println("88888888888888888888");
        return "login";
    }

    @RequestMapping(value = "/updtPassword",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updatePassword(String oldpassword,String password, HttpSession session){
        try {
            Admain admain = (Admain) session.getAttribute("admain");
            if(oldpassword.equals(admain.getPassword())) {
                admain.setPassword(password);
                System.out.println(admain);
                admainService.motifyAdmainPassword(admain);
                session.setAttribute("admain", admain);
                result.put("success",true);
            }else{
                result.put("success",false);
            }
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("massage",e.getMessage());
        }
        return result;
    }
}
