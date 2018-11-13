package com.baizhi.service;

import com.baizhi.bean.Album;

import java.util.Map;

public interface AlbumService {
    /*上传专辑*/
    void addAlbum(Album album);
    /*修改专辑信息*/
    void motifyAlbum(Album album);
    /*删除专辑*/
    void delAlbum(Album album);
    /*查找某张专辑信息*/
    Album findOneAlbum(Album album);
    /*查看所有专辑*/
    Map<String, Object> findAllAlbum();
}
