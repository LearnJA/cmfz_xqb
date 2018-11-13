package com.baizhi.controller;

import com.baizhi.bean.Guru;
import com.baizhi.service.GuruService;
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
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;
    private Map<String,Object> result=new HashMap<String, Object>();
    private Guru guru=new Guru();

    @RequestMapping(value = "/findGurus",method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody Map<String,Object> findGuru(Integer status, Integer page, Integer rows){
        result=guruService.findOneGrur(status,page,rows);
        return result;
    }

    @RequestMapping(value = "/add",method ={RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody Map<String,Object> addGuru(Guru guru){
        try{
            guru.setHeadPic("/HeadImg/headPic.jpg");
            guruService.addGuru(guru);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("messge",e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/update")
    public @ResponseBody Map<String,Object> updateGuru(Guru guru){
        try{
            System.out.println("*********///////////**********"+guru);
            guruService.motifyGuru(guru);
            result.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "del",method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody Map<String,Object> delGuru(Guru guru){
        System.out.println(guru);
        try{
            System.out.println("11111111111111111");
            guruService.deleteGuru(guru);
            result.put("success",true);
        }catch(Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }

    /*上传上师头像*/
    @RequestMapping(value = "/uploadHead")
    public @ResponseBody Map<String,Object> uploadHeadPic(Integer id,MultipartFile file,HttpSession session){
        System.out.println("/////888888888///////"+file);
        try{
            guru.setId(id);
            FileParm fileParm =UploadFile.addfile("/HeadImg",file,session);
            System.out.println("////////****"+fileParm.getPath()+"**********//////////////");
            guru.setHeadPic(fileParm.getPath());
            System.out.println(guru);
            guruService.motifyGuru(guru);
            result.put("success",true);

        }catch(Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        return result;
    }
}
