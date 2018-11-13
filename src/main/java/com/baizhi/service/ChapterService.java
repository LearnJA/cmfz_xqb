package com.baizhi.service;

import com.baizhi.bean.Chapter;

import java.util.Map;

public interface ChapterService {
    /*添加专辑章节*/
    void addChapter(Chapter chapter);
    /*删除某个章节*/
    void deleteChapter(Chapter chapter);
    /*查一个*/
    Chapter findOne(Chapter chapter);
    /*查所有*/
    Map<String,Object> findAll(Integer page,Integer rows);
}
