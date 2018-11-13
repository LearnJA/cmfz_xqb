package com.baizhi.service;

import com.baizhi.bean.Banner;

import java.util.List;
import java.util.Map;

public interface BannerService {
    /*添加轮播图片*/
    void addBanner(Banner banner);
    /*修改轮播图片状态*/
    void motifyBanner(Banner banner);
    /*彻底删除轮播图*/
    void removeBanner(Banner banner);
    /*批量删除轮播图*/
    void removeAnyBanner(int[] ids);
    /*查一张轮播图*/
    Banner findOneBanner(Banner banner);
    /*展示库存轮播图*/
    Map<String, Object> findAllBanner(Integer status, Integer page, Integer rows);
}
