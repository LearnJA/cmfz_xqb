package com.baizhi.bean;

import java.util.List;

public class Guru {
    private Integer id;
    private String name;
    private String headPic;
    private Integer status;

    private List<Article> children;

    public Guru() {
    }

    public Guru(Integer id, String name, String headPic, Integer status) {
        this.id = id;
        this.name = name;
        this.headPic = headPic;
        this.status = status;
    }

    public Guru(Integer id, String name, String headPic, Integer status, List<Article> children) {
        this.id = id;
        this.name = name;
        this.headPic = headPic;
        this.status = status;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Article> getChildren() {
        return children;
    }

    public void setChildren(List<Article> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headPic='" + headPic + '\'' +
                ", status=" + status +
                ", children=" + children +
                '}';
    }
}
