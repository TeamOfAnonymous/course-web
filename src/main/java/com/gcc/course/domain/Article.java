package com.gcc.course.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by WangZK on 2017/3/12.
 * 文章实体类
 */
@Entity
public class Article extends BaseEntity {

    private String title;//标题
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime publishedTime; //发表时间

    @Column(length = 16777216)
    //@Column(columnDefinition = "longtext") //columnDefinition不推荐使用，因为可能导致移植性不好，各个数据库不兼容等。
    private String mdContent; //正文md格式

    @ManyToMany(mappedBy = "articles")
    private Set<Tag> tags = new HashSet<>();

    @Column(columnDefinition = "INT default 0")
    private Integer state; //文章状态，1为发布，0为未发布

    public Article() {
        this.publishedTime = LocalDateTime.now();
        this.state = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(LocalDateTime publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
