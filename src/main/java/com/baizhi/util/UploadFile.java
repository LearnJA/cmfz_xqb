package com.baizhi.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadFile {
    /*上传文件*/
    public static FileParm addfile(String realPath, MultipartFile file, HttpSession session) throws IOException {
        /*获取项目绝对存储路径*/
        ServletContext context=session.getServletContext();
        String localPath=context.getRealPath(realPath);
        //获取文件名
        String oldfilename=file.getOriginalFilename();
        //获取文件后缀名
        String aftername=FilenameUtils.getExtension(oldfilename);
        /*获取新文件名*/
        String newname=UUID.randomUUID()+"."+aftername;
        /*创建文件对象 */
        File destFile=new File(localPath+"/"+newname);
        /*写入指定路径*/
        file.transferTo(destFile);
        /*返回文件相对路径*/
        String filePath=realPath+"/"+newname;
        /*获取文件大小*/
        String size=file.getSize()/1024/1000+"M";
        return new FileParm(filePath,newname,oldfilename,size);
    }
}
