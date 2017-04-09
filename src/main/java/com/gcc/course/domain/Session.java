package com.gcc.course.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 * decription : 章节实体
 */
@Entity
public class Session extends BaseEntity {

    private String name; // 名称
    private String description; // 简介

    private int sort_order ; // 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime addTime; // 添加时间

    @ManyToOne
    private Course course;

    public Session() {
        this.addTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
