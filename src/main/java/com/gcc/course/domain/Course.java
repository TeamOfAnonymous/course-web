package com.gcc.course.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangMP on 2017/3/30.
 * decription : 课程实体
 */
@Entity
@Where(clause = "status != 1")
public class Course extends BaseEntity {

    private String name; // 名称
    private String description; //简介
    private String imgUrl; //图片路径
    private String prompt ; // 提示
    private int sortOrder ; //排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime addTime; //添加时间

    @OneToMany
    private List<Section> sections = new ArrayList();

    public Course() {
        this.addTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

}
