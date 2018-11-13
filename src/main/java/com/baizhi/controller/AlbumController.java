package com.baizhi.controller;

import com.baizhi.bean.Album;
import com.baizhi.service.AlbumService;
import com.baizhi.util.FileParm;
import com.baizhi.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    private Map<String,Object> result=new HashMap<String,Object>();
    private Album album=new Album();

    @RequestMapping(value = "/findAll")
    public @ResponseBody Map<String,Object> findAllAlbum(){
        result=albumService.findAllAlbum();
        return result;
    }
    @RequestMapping(value = "/add")
    public @ResponseBody Map<String,Object> addAlbum(Album album,MultipartFile file,HttpSession session){
        try{
            /*上传封面图片*/
            FileParm fileParm=UploadFile.addfile("/FaceImg",file,session);
            album.setPublishDate(new Date());
            album.setFaceImg(fileParm.getPath());
            album.setCount(0);
            System.out.println(album);
            albumService.addAlbum(album);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }
    /*上传专辑封面*/
    @RequestMapping("/uploadFace")
    public Map<String,Object> uploadFaceImg(Integer id, MultipartFile file, HttpSession session){
        try{
            album.setId(id);
            String faceImg=UploadFile.addfile("/FaceImg",file,session).getFilename();
            album.setFaceImg(faceImg);
            System.out.println(album);
            albumService.motifyAlbum(album);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }

    /*查一个*/
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public @ResponseBody Album findOneAlbum(Album album){
        album=albumService.findOneAlbum(album);
        System.out.println(album);
        return album;
    }

    /*删除专辑*/
    @RequestMapping(value = "/delAlbum")
    public @ResponseBody Map<String,Object> delAlbum(Album album){
        try{
            albumService.delAlbum(album);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
        }
        return result;
    }
}
