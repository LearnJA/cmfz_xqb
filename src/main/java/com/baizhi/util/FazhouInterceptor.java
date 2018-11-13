package com.baizhi.util;

import com.baizhi.bean.Admain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FazhouInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {
        //获取访问路径中的相对路径
        String uri=request.getRequestURI();
        System.out.println(uri);
        //验证码请求通过
        if(!(uri.indexOf("/code/vc.do")==-1)){
            return true;
        }
        //判断路径是否指向登录方法
        if(uri.indexOf("/admain/login.do")==-1){
            System.out.println("--------拦截--------");
            //获取Session取出作用域中存储的标志位
            HttpSession session=request.getSession();
            Admain admain= (Admain) session.getAttribute("admain");
            System.out.println(admain);
            if(admain!=null){
                //不为空时表示管理员已登录直接放行
                System.out.println("--------!!!!--------");
                return true;
            }//否则表示你未登录 跳转到登录界面
            try {
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("*************-------!!!!--------*************");
            return false;
        }else{
            System.out.println("--------通过--------");
            return true;
        }
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception {

    }
}
