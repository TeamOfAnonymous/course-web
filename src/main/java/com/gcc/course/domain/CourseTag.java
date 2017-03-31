package com.gcc.course.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangMP on 2017/3/30.
 * decription : 标签实体
 */
@Entity
@Where(clause = "status != 1")
public class CourseTag extends BaseEntity{

    private String name; // 名称

    private String description; //简介

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime addTime; //添加时间

    @ManyToMany(mappedBy = "courseTags")
    @JsonIgnore
    private List<Course> courses = new ArrayList() ; // 其下的课程

    public CourseTag() {
        this.addTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public CourseTag(String name) {
        this.name = name;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
