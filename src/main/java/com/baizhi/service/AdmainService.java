package com.baizhi.service;

import com.baizhi.bean.Admain;

@SuppressWarnings("SpellCheckingInspection")
public interface AdmainService {
    /*登录*/
    Admain findOneAdmain(Admain admain);
    /*注册*/
    void addAdmain(Admain admain);
    /*修改密码*/
    void motifyAdmainPassword(Admain admain);
}
