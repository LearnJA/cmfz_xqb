package com.baizhi.util;

public class FileParm {
    private String path;
    private String newfilename;
    private String filename;
    private String size;
    private String absolutUploadPath="D:\\后期项目\\cmfz_xqb\\target\\cmfz_xqb\\Chapter";
    private String absolutDwonloadPath="D:\\后期项目\\cmfz_xqb\\target\\cmfz_xqb\\";

    public FileParm() {
    }

    public FileParm(String path, String newfilename, String filename, String size) {
        this.path = path;
        this.newfilename = newfilename;
        this.filename = filename;
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNewfilename() {
        return newfilename;
    }

    public void setNewfilename(String newfilename) {
        this.newfilename = newfilename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAbsolutUploadPath() {
        return absolutUploadPath;
    }

    public String getAbsolutDwonloadPath() {
        return absolutDwonloadPath;
    }

    @Override
    public String toString() {
        return "FileParm{" +
                "path='" + path + '\'' +
                ", newfilename='" + newfilename + '\'' +
                ", filename='" + filename + '\'' +
                ", size='" + size + '\'' +
                ", absolutUploadPath='" + absolutUploadPath + '\'' +
                ", absolutDwonloadPath='" + absolutDwonloadPath + '\'' +
                '}';
    }
}
