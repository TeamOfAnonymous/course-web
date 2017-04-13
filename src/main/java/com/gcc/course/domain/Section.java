package com.gcc.course.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by WangZK on 2017/3/20.
 * decription : 章节实体
 */
@Entity
//@JsonIgnoreProperties(value = {"course"})
public class Section extends BaseEntity {

    private String name; // 名称
    private String description; // 简介
    private int orderIndex; // 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime addTime; // 添加时间

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JsonIgnore
    private Course course;
    @ManyToMany
    private Set<Tag> tags  = new HashSet<>();

    public Section() {
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

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
