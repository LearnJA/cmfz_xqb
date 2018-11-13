package com.baizhi.service;

import com.baizhi.bean.Album;
import com.baizhi.bean.Chapter;
import com.baizhi.dao.AlbumDAO;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.util.FindList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDAO albumDAO;
    @Autowired
    private ChapterDAO chapterDAO;
    private Chapter chapter=new Chapter();


    @Override
    public void addAlbum(Album album) {
        albumDAO.insert(album);
    }

    @Override
    public void motifyAlbum(Album album) {
        albumDAO.update(album);
    }

    @Override
    public void delAlbum(Album album) {
        /*删除专辑就必须将专辑下所有章节删除*/
        chapter.setAlbum_id(album.getId());
        chapterDAO.delete(chapter);
        /*再删除专辑*/
        albumDAO.delete(album);
    }

    @Override
    public Album findOneAlbum(Album album) {
        return albumDAO.queryOne(album);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> findAllAlbum() {
        List<Album> albums=albumDAO.queryAll();
        Long total=albumDAO.queryAllCount();
        return FindList.findList(total,albums);
    }


}
