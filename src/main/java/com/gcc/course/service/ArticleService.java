package com.gcc.course.service;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Session;
import com.gcc.course.utils.RequestResult;

import java.util.List;

/**
 * Created by WangZK on 2017/3/12.
 */
public interface ArticleService {

    RequestResult save(Article article);

    Article get(String id);

    List<Article> getArticleList(String id);

    RequestResult update(Article article);

    boolean remove(String id);

    boolean recovery(String id);
}
