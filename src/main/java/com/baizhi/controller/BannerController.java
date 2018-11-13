package com.baizhi.controller;

import com.baizhi.bean.Banner;
import com.baizhi.service.BannerService;
import com.baizhi.util.FileParm;
import com.baizhi.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@Controller
@Scope("prototype")
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    private Map<String,Object> result=new HashMap<String,Object>();
    private Banner bimg=new Banner();

    /*展示轮播图*/
    @RequestMapping(value = "/findBanners",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> findBanner(Integer status,Integer page,Integer rows){
        result=bannerService.findAllBanner(status,page,rows);
        return result;
    }
    //轮播图上传
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> addBanner(Banner banner, HttpSession session){
        try {
            /*上传文件入服务器本地文件库*/
            FileParm fileParm=UploadFile.addfile("/BannerImg",banner.getFile(),session);
            banner.setImgPath(fileParm.getPath());
            banner.setDate(new Date());
            /*调用业务文件信息入库*/
            bannerService.addBanner(banner);
        } catch (IOException e) {
            e.printStackTrace();
            result.put("success",false);
            return result;
        }
        result.put("success",true);
        return result;
    }
    /*查一个*/
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public @ResponseBody Banner findAdmain(Integer id){
        bimg.setId(id);
        Banner banner=bannerService.findOneBanner(bimg);
        return banner;
    }
    /*修改*/
    @RequestMapping(value = "/updt",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updtBanner(Banner banner){
        try {
            System.out.println("00000000000000000"+banner);
            banner.setDate(new Date());
            bannerService.motifyBanner(banner);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            return result;
        }
        result.put("success",true);
        return result;
    }

    /*批量删除*/
    @RequestMapping(value = "delAny",method = RequestMethod.POST)
    public Map<String,Object> delAnyBanner(int[] ids){
        try {
            System.out.println(ids);
            bannerService.removeAnyBanner(ids);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("error",e.getMessage());
        }
        return result;
    }
}
