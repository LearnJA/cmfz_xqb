package com.baizhi.dao;

import com.baizhi.bean.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDAO extends BaseDAO<Album>{
    /*统计条数*/
    Long queryAllCount();
    /*包含章节的所有专辑*/
    List<Album> queryAllChpter(@Param("start") Integer start,@Param("rows") Integer rows);
}
