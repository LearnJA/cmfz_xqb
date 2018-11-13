package com.baizhi.bean;

public class Admain {
    private Integer id;
    private String name;
    private String password;
    private Integer status;

    private String enCode;

    public Admain() {
    }

    public Admain(Integer id, String name, String password, Integer status, String enCode) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
        this.enCode = enCode;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEnCode() {
        return enCode;
    }

    public void setEnCode(String enCode) {
        this.enCode = enCode;
    }

    @Override
    public String toString() {
        return "Admain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", enCode='" + enCode + '\'' +
                '}';
    }
}
