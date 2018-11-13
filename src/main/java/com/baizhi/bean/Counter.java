package com.baizhi.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Counter {
    private Integer id;
    private String title;
    private Integer count;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date recodeDate;
    private Integer user_id;
    private Integer course_id;

    public Counter() {
    }

    public Counter(Integer id, String title, Integer count, Date recodeDate, Integer user_id, Integer course_id) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.recodeDate = recodeDate;
        this.user_id = user_id;
        this.course_id = course_id;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getRecodeDate() {
        return recodeDate;
    }

    public void setRecodeDate(Date recodeDate) {
        this.recodeDate = recodeDate;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", recodeDate=" + recodeDate +
                ", user_id=" + user_id +
                ", course_id=" + course_id +
                '}';
    }
}
