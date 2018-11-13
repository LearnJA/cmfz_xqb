package com.baizhi.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class Banner {
    private Integer id;
    private String title;
    private String imgPath;
    private String desct;
    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private MultipartFile file;

    public Banner() {
    }

    public Banner(Integer id, String title, String imgPath, String desct, Integer status, Date date, MultipartFile file) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.desct = desct;
        this.status = status;
        this.date = date;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDesct() {
        return desct;
    }

    public void setDesct(String desct) {
        this.desct = desct;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", desct='" + desct + '\'' +
                ", status=" + status +
                ", date=" + date +
                ", file=" + file +
                '}';
    }
}
