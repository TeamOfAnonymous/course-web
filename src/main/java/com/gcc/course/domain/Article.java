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
public class Article {

    @Id
    @GeneratedValue(generator = "UUID2_GENERATOR")
    private String id;

    private String title;//标题
    private String author;//作者
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime publishedTime; //发表时间

    @Column(length = 16777216)
    private String mdContent; //正文md格式

    @ManyToOne
    private Session session; //所属章节

    @Column(columnDefinition = "INT default 0")
    private int is_deleted; //是否被删除，1为true，0为false；

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime deletedTime; //删除时间

    public Article() {
        this.publishedTime = LocalDateTime.now();
        this.is_deleted = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public LocalDateTime getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(LocalDateTime deletedTime) {
        this.deletedTime = deletedTime;
    }


}
