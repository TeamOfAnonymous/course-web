package com.gcc.course.domain;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by WangZK on 2017/4/8.
 */
@Entity
public class Tag {

    @Id
    @GeneratedValue(generator = "UUID2_GENERATOR")
    private String id;
    private String name;

    @ManyToMany(mappedBy = "tags",fetch = FetchType.EAGER)
    private Set<Article> articles = new HashSet<>();

    public Tag() {

    }

    public Tag(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

}
