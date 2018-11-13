package com.baizhi.service;

import com.baizhi.bean.Admain;
import com.baizhi.dao.AdmainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("ALL")
@Service
@Transactional
public class AdmainServiceImpl implements AdmainService {

    @Autowired
    private AdmainDAO admainDAO;


    @Override
    public Admain findOneAdmain(Admain admain) {
        return admainDAO.queryOne(admain);
    }

    @Override
    public void addAdmain(Admain admain) {
        admainDAO.queryOne(admain);
    }

    @Override
    public void motifyAdmainPassword(Admain admain) {
        admainDAO.update(admain);
    }
}
