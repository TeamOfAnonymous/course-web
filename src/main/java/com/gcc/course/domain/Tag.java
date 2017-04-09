package com.gcc.course.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by WangZK on 2017/4/8.
 */
@Entity
public class Tag {

    @Id
    @GeneratedValue(generator = "UUID2_GENERATOR")
    private String id;
    private String name;

    @ManyToMany
    @JoinTable(name = "tag_article", joinColumns = {
            @JoinColumn(name = "tagId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "articleId", referencedColumnName = "id")})
    private Set<Article> articles;

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
