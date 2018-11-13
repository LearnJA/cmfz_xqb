package com.baizhi.service;

import com.baizhi.bean.Album;
import com.baizhi.bean.Chapter;
import com.baizhi.dao.AlbumDAO;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.util.FindList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    /**
     * 章节与专辑关联   该章节必须改变专辑的章节数量
     * @param character
     */

    @Autowired
    private AlbumDAO albumDAO;
    @Autowired
    private ChapterDAO chapterDAO;
    private Album album=new Album();

    @Override
    public void addChapter(Chapter chapter) {
        /*先修改对应专辑章节数量*/
        album.setId(chapter.getAlbum_id());
        System.out.println("//////*****"+album);
        album=albumDAO.queryOne(album);
        System.out.println(album);
        album.setCount(album.getCount()+1);
        System.out.println("数量"+album);
        albumDAO.update(album);
        /*再入库*/
        chapterDAO.insert(chapter);
    }

    @Override
    public void deleteChapter(Chapter chapter) {
        chapterDAO.delete(chapter);
    }

    @Override
    public Chapter findOne(Chapter chapter) {
        return chapterDAO.queryOne(chapter);
    }

    @Override
    public Map<String, Object> findAll(Integer page,Integer rows) {
        Integer start=(page-1)*rows;
        List<Album> albums=albumDAO.queryAllChpter(start,rows);
        Long total=albumDAO.queryAllCount();
        return FindList.findList(total,albums);
    }
}
