package com.baizhi.controller;

import com.baizhi.bean.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.FileParm;
import com.baizhi.util.FileTime;
import com.baizhi.util.UploadFile;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@Scope("prototype")
@RequestMapping("/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;
    FileParm fileParm=new FileParm();
    private Map<String,Object> result=new HashMap<String,Object>();


    /*展示所有章节*/
    @RequestMapping(value = "/findAll")
    public @ResponseBody Map<String,Object> findAllChapter(Integer page,Integer rows){
        result=chapterService.findAll(page,rows);
        return result;
    }

    /*删除章节*/
    @RequestMapping(value = "/delChapter")
    public @ResponseBody Map<String,Object> delChapter(Chapter chapter){
        try{
            System.out.println("//////*******//////////"+chapter);
            chapterService.deleteChapter(chapter);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
        }
        return result;
    }
    /*添加章节*/
    @RequestMapping(value = "/add")
    public @ResponseBody Map<String,Object> addChapter(Chapter chapter, MultipartFile file, HttpSession session){
        try{
            System.out.println(chapter);
            String ufilename=UUID.randomUUID().toString();
            /*先上传文件*/
            FileParm fileParm=UploadFile.addfile("/Chapter",file,session);
            /*获取音频时长*/
            String time=FileTime.getFileTimelength(fileParm.getNewfilename());
            chapter.setDuration(time);
            chapter.setSize(fileParm.getSize());
            chapter.setDownPath(fileParm.getPath());
            chapter.setTitle(fileParm.getFilename());
            chapter.setUploadDate(new Date());
            chapter.setId(ufilename);
            System.out.println("///////*******////"+chapter);
            chapterService.addChapter(chapter);
            System.out.println(chapter);
            result.put("success",true);
        }catch(Exception e){
            result.put("success",false);
            result.put("meaasge",e.getMessage());
        }
        return result;
    }

    /*下载章节*/
    @RequestMapping(value = "/down",method = RequestMethod.GET)
    public ResponseEntity<byte[]> downChapter(String id) {
        //OutputStream outputStream=response.getOutputStream();
        Chapter chapter=new Chapter();chapter.setId(id);
            System.out.println(chapter);
            /*查出对应章节信息*/
            chapter=chapterService.findOne(chapter);
            System.out.println(chapter);
            String path=chapter.getDownPath();
            String downloadPath=fileParm.getAbsolutDwonloadPath()+path;
            System.out.println(downloadPath);
            String filename=chapter.getTitle();
            /*下载*/
        InputStream in= null;//将该文件加入到输入流之中
        ResponseEntity<byte[]> response=null;
        try {
            in = new FileInputStream(new File(downloadPath));

        byte[] body=null;
            body=new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
            in.read(body);//读入到输入流里面

            filename=new String(filename.getBytes("gbk"),"iso8859-1");//防止中文乱码
            HttpHeaders headers=new HttpHeaders();//设置响应头
            headers.add("Content-Disposition", "attachment;filename="+filename);
            HttpStatus statusCode = HttpStatus.OK;//设置响应吗
            response=new ResponseEntity<byte[]>(body, headers, statusCode);
        } catch (Exception e) {
            e.printStackTrace();
            response=null;
        }
            return response;
    }
}
