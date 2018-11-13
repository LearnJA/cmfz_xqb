package com.baizhi.util;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

public class FileTime {
    public static String getFileTimelength(String newname){
        FileParm fileParm=new FileParm();
        /*获取时长*/
        String duration=null;
        String path=fileParm.getAbsolutUploadPath()+"/"+newname;
        System.out.println(path);
        try {
            File pathFile=new File(path);
            /*创建二进制码对象*/
            Encoder encoder = new Encoder();
            long ls = 0;
            /*核心计算时长对象*/
            MultimediaInfo m = encoder.getInfo(pathFile);
            ls = m.getDuration();
            duration=ls / 60000 + ":" + ls / 1000 ;
            System.out.println(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return duration;
    }
}
