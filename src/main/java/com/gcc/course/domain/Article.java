package com.gcc.course.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @ManyToOne
    private Session session; //所属章节

    public Article() {
        this.publishedTime = LocalDateTime.now();
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

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
