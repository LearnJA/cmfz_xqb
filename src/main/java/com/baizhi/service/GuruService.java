package com.baizhi.service;

import com.baizhi.bean.Guru;

import java.util.List;
import java.util.Map;

public interface GuruService {
    /*添加上师*/
    void addGuru(Guru guru);
    /*修改上师信息*/
    void motifyGuru(Guru guru);
    /*彻底删除*/
    void deleteGuru(Guru guru);
    /*展示所有(包括历史)上师*/
    List<Guru> findAllGuru();
    /*根据状态展示上师*/
    Map<String, Object> findOneGrur(Integer status,Integer page,Integer rows);
}
